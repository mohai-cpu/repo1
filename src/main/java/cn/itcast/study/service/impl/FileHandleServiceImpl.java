package cn.itcast.study.service.impl;

import cn.itcast.study.service.FileHandleService;
import cn.itcast.study.utils.ReturnResult;
import cn.itcast.study.utils.TimeUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.UUID;

@Service
public class FileHandleServiceImpl implements FileHandleService {
    private Logger logger = LoggerFactory.getLogger(FileHandleServiceImpl.class);
    @Value("${filetest.uploadurl}")
    private String uploadPath;
    @Value("${filetest.downloadurl}")
    private String downloadPath;
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
}
