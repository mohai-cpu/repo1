package cn.itcast.study.service.impl;

import cn.itcast.study.service.FileHandleService;
import cn.itcast.study.utils.PictureUtil;
import cn.itcast.study.utils.ReturnResult;
import cn.itcast.study.utils.TimeUtils;
import com.alibaba.fastjson.JSONObject;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

@Service
public class FileHandleServiceImpl implements FileHandleService {
    private Logger logger = LoggerFactory.getLogger(FileHandleServiceImpl.class);
    @Value("${filetest.uploadurl}")
    private String uploadPath;
    @Value("${filetest.downloadurl}")
    private String downloadPath;
    @Autowired
    private PictureUtil pictureUtil;
    private static final String mini = "_mini";
    private static final String icon = "icon";
    @Override
    public ReturnResult fileUpload(HttpServletRequest request,MultipartFile file) {
        logger.info("***********************文件上传开始**************************");
        ReturnResult returnResult = new ReturnResult();
        //1.判断文件是否为空
        if(file.isEmpty()){
            returnResult.setCode(2001);
            returnResult.setMsg("parm file is sempty");
            return returnResult;
        }
        if(!ServletFileUpload.isMultipartContent(request)){
            returnResult.setCode(2002);
            returnResult.setMsg("request的enctype不是multipart/form-data");
            return returnResult;
        }
       // logger.info("fileUpload;需要上传的文件file:{}", JSONObject.toJSONString(file));
        //2.获取文件相关信息
        String filename = file.getOriginalFilename();
        //文件类型 jpg video 等
        String fileType = filename.substring(filename.lastIndexOf(".") + 1);
        int size = (int)file.getSize();
        logger.info("fileUpload;文件信息filename:{};size:{}",filename,size);
        //3.生成uuid 拼接fileType保证文件唯一
        String uuid = UUID.randomUUID().toString();
        Date date = new Date();
       /* SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        String datestr = sf.format(date);*/
        String datestr = TimeUtils.convertDateToStringBySample(date, "yyyyMMdd");
        //4.设置上传路径
        File filePath = new File(uploadPath+File.separator+datestr+File.separator+uuid+"."+fileType);
        if(!filePath.getParentFile().exists())
            filePath.getParentFile().mkdirs();
        try {
            file.transferTo(filePath);
            returnResult.setCode(2000);
            returnResult.setMsg("文件上传成功");
            return returnResult;
        } catch (Exception e) {
            logger.info("fileUpload;文件上传异常e:{}",e);
            returnResult.setCode(2003);
            returnResult.setMsg("文件上传异常");
            return returnResult;
        }
    }

    @Override
    public ReturnResult fileUpload2(byte[] fileBytes, String sessionId, String fromId, String fileClass, String fileType) throws IOException {
        ReturnResult returnInfo = new ReturnResult();
        //返回信息map
        Map<String, String> returnMap = new HashMap<>();
        //生成UUID
        String uuid = UUID.randomUUID().toString();
        logger.info("method: filesUpload uuid的值是【{}】", uuid);
        //获取当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String nowTime = simpleDateFormat.format(new Date());
        //设置上传路径
        String path = uploadPath + File.separator + nowTime + File.separator + sessionId + File.separator + fromId + File.separator + uuid + "." + fileType;
        File filePath = new File(uploadPath + File.separator + nowTime + File.separator + sessionId + File.separator + fromId);
        File fileUpPath = new File(path);
        if (("true").equals(createFilePath(filePath))) {
            if ("IMAGE".equals(fileClass)) {
                //将图片文件保存到服务器的文件名称
                File miniPictureFile = new File(uploadPath + File.separator + nowTime + File.separator + sessionId + File.separator + fromId + File.separator + uuid + mini + "." + fileType);
                try (FileOutputStream fileOutputStream = new FileOutputStream(path);) {
                    // 创建原图文件
                    pictureUtil.createFile(fileUpPath);
                    // 读取原图
                    BufferedImage BI = ImageIO.read(new ByteArrayInputStream(fileBytes));
                    // 获取原图片的宽和高
                    String width = String.valueOf(BI.getWidth());
                    // 创建缩略图文件
                    pictureUtil.createThumbnaiFile(fileBytes, miniPictureFile, width);
                    logger.info("method: filesUpload;缩略之后的图片大小fileBytes.length:{}",fileBytes.length);
                    fileOutputStream.write(fileBytes);
                    String wholeName = fileUpPath.getName();
                    String miniName = miniPictureFile.getName();
                    logger.info("method: filesUpload 上传的图片名称是【{}】【{}】", wholeName, miniName);
                    returnInfo.setCode(2000);
                    returnMap.put("wholeName", wholeName);
                    returnMap.put("miniName", miniName);
                    returnInfo.setData(JSONObject.toJSONString(returnMap));
                    returnInfo.setMsg("picture upload success");
                    //修改权限
                    // Runtime.getRuntime().exec("chmod -R 777 " + filePath.getParentFile().getPath());
                } catch (Exception e) {
                    returnInfo.setCode(2007);
                    returnInfo.setMsg("picture upload abnormal");
                    logger.info("method: filesUpload 图片上传异常【{}】", e);
                }
            } else if ("SHORTVIDEO".equals(fileClass)) {
                if ("false".equals(checkVideo(fileType))) {
                    returnInfo.setCode(2009);
                    returnInfo.setMsg("must upload video");
                    return returnInfo;
                }
                //上传视频文件
                returnInfo = uploadFile(fileUpPath, fileBytes);
                if ("2008".equals(returnInfo.getCode())) {
                    return returnInfo;
                }
                //视频截图
                FFmpegFrameGrabber fFmpegFrameGrabber = null;
                try {
                    fFmpegFrameGrabber = FFmpegFrameGrabber.createDefault(fileUpPath);
                    fFmpegFrameGrabber.start();
                    int lengthInFrames = fFmpegFrameGrabber.getLengthInFrames();
                    Frame frame;
                    int i = 0;
                    while (i < lengthInFrames) {
                        frame = fFmpegFrameGrabber.grabImage();
                        //截取第1帧
                        if ((i > 0) && (frame.image != null)) {
                            //图片地址
                            String imagePath = uploadPath + File.separator + nowTime + File.separator + sessionId + File.separator + fromId + File.separator + uuid + ".png";
                            logger.info("method: filesUpload 截图路径【{}】", imagePath);
                            //截取缩略图
                            String returnMessage = cropImage(frame, imagePath, fFmpegFrameGrabber);
                            if ("false".equals(returnMessage)) {
                                returnInfo.setCode(2010);
                                returnInfo.setData(null);
                                returnInfo.setMsg("frame is null");
                            } else {
                                returnMap.put("video", returnInfo.getData().toString());
                                returnMap.put("cropImage", uuid + ".png");
                                returnInfo.setData(JSONObject.toJSONString(returnMap));
                            }
                            break;
                        }
                        i++;
                    }
                } catch (FrameGrabber.Exception e) {
                    logger.info("method: filesUpload 获取视频帧数异常【{}】", e);
                    returnInfo.setCode(2011);
                    returnInfo.setMsg("get video frame abnormal");
                    return returnInfo;
                } finally {
                    if (fFmpegFrameGrabber != null) {
                        fFmpegFrameGrabber.close();
                    }
                }
            } else {
                //上传其他文件
                returnInfo = uploadFile(fileUpPath, fileBytes);
            }
        } else {
            returnInfo.setCode(2012);
            returnInfo.setMsg("create filePath wrong");
        }
        return returnInfo;
    }

    @Override
    public ReturnResult fileDownload(HttpServletResponse response) throws Exception {
        logger.info("***********************文件下载开始**************************");
        ReturnResult returnResult = new ReturnResult();
        String filename = "11.jpg";
        File file = new File(downloadPath+File.separator+filename);
        if(file.exists()){
            response.setHeader("content-type", "image/jpg");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + filename);
            byte[] buffer = new byte[1024];
            //文件输入流
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            //输出流
            OutputStream os = null;
            try{
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while (i!=-1){
                    os.write(buffer);
                    os.flush();
                    i = bis.read(buffer);
                }
            }catch (Exception e){
                returnResult.setCode(2001);
                returnResult.setMsg("文件下载异常");
                return null;
            }finally {
                try {
                    if(os != null)
                        os.close();
                    if (bis != null)
                        bis.close();
                    if(fis != null)
                        fis.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        returnResult.setCode(2000);
        returnResult.setMsg("文件下载成功");
        return null;
    }
    //创建储存文件路径
    private String createFilePath(File filePath) {
        try {
            if (!filePath.exists()) {
                pictureUtil.createDir(filePath);
            }
        } catch (Exception e) {
            logger.info("method: filesUpload 创建上传文件路径异常【{}】", e);
            return "false";
        }
        return "true";
    }

    //上传文件
    private ReturnResult uploadFile(File file, byte[] fileBytes) {
        ReturnResult returnInfo = new ReturnResult();
        String name = file.getName();
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);) {
            fileOutputStream.write(fileBytes);
        } catch (IOException e) {
            logger.info("method:uploadFile 上传文件出现异常", e);
            returnInfo.setCode(2008);
            returnInfo.setMsg("file upload  abnormal");
            return returnInfo;
        }
        returnInfo.setCode(2000);
        returnInfo.setData(name);
        returnInfo.setMsg("file upload success");
        return returnInfo;
    }
    //获取视频截图
    private String cropImage(Frame frame, String imagePath, FFmpegFrameGrabber fFmpegFrameGrabber) throws IOException {
        if (frame == null || frame.image == null) {
            return "false";
        } else {
            Java2DFrameConverter java2DFrameConverter = new Java2DFrameConverter();
            BufferedImage bufferedImage = java2DFrameConverter.getBufferedImage(frame);
            //旋转视频截图
            String rotate = fFmpegFrameGrabber.getVideoMetadata("rotate");
            if (rotate != null) {
                bufferedImage = rotate(bufferedImage, Integer.parseInt(rotate));
            }
            //获取截图高度
            String imgWidth = String.valueOf(bufferedImage.getWidth());
            File imgPath = new File(imagePath);
            // 创建缩略图文件
            try {
                int parseWidth = Integer.parseInt(imgWidth);
                //按比例缩放
                if (parseWidth > 1000) {
                    float num = (float) 300 / Integer.parseInt(imgWidth);
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    String radio = decimalFormat.format(num);
                    Thumbnails.of(bufferedImage).scale(Float.parseFloat(radio)).toFile(imgPath);
                    logger.info("miniPictureFile createNewFile  success!");
                } else {
                    Thumbnails.of(bufferedImage).scale(0.3f).toFile(imgPath);
                }
            } catch (IOException e) {
                logger.info("miniPictureFile createNewFile fail!", e);
            }
            return "true";
        }
    }

    //旋转视频截图
    private BufferedImage rotate(BufferedImage bufferedImage, int rotate) {
        int imgWidth = bufferedImage.getWidth(null);
        int imgHeight = bufferedImage.getHeight(null);
        int type = bufferedImage.getColorModel().getTransparency();
        Rectangle rectangle = calcRotatedSize(new Rectangle(new Dimension(imgWidth, imgHeight)), rotate);
        BufferedImage buffImg = new BufferedImage(rectangle.width, rectangle.height, type);
        Graphics2D graphics = buffImg.createGraphics();
        graphics.translate((rectangle.width - imgWidth) / 2, (rectangle.height - imgHeight) / 2);
        graphics.rotate(Math.toRadians(rotate), (double) imgWidth / 2, (double) imgHeight / 2);
        graphics.drawImage(bufferedImage, 0, 0, null);
        graphics.dispose();
        return buffImg;
    }

    //计算旋转图片的角度大小
    private Rectangle calcRotatedSize(Rectangle rectangle, int rotate) {
        if (rotate >= 90) {
            if (rotate / 90 % 2 == 1) {
                int height = rectangle.height;
                rectangle.height = rectangle.width;
                rectangle.width = height;
            }
            rotate = rotate % 90;
        }
        double v = Math.sqrt((double) rectangle.height * (double) rectangle.height + (double) rectangle.width * (double) rectangle.width) / 2;
        double len = 2 * Math.sin(Math.toRadians(rotate) / 2) * v;
        double rotateAlpha = (Math.toRadians(rotate)) / 2;
        double rotateDeltaWidth = Math.atan((double) rectangle.height / rectangle.width);
        double rotateDeltaHeight = Math.atan((double) rectangle.width / rectangle.width);
        int lenDeltaWidth = (int) (len * Math.cos(Math.PI - rotateAlpha - rotateDeltaWidth));
        int lenDeltaHeight = (int) (len * Math.cos(Math.PI - rotateAlpha - rotateDeltaHeight));
        int desWidth = rectangle.width + lenDeltaWidth * 2;
        int desHeight = rectangle.height + lenDeltaHeight * 2;
        return new Rectangle(new Dimension(desWidth, desHeight));
    }

    //校验视频格式
    private String checkVideo(String fileType) {
        String str = fileType.toLowerCase();
        switch (str) {
            case "mp4":
                return "true";
            case "m4v":
                return "true";
            case "wmv":
                return "true";
            case "asf":
                return "true";
            case "asx":
                return "true";
            case "rm":
                return "true";
            case "rmvb":
                return "true";
            case "mpg":
                return "true";
            case "mpeg":
                return "true";
            case "mpe":
                return "true";
            case "3gp":
                return "true";
            case "mov":
                return "true";
            case "avi":
                return "true";
            case "dat":
                return "true";
            case "mkv":
                return "true";
            case "flv":
                return "true";
            case "vob":
                return "true";
        }
        return "false";
    }
}
