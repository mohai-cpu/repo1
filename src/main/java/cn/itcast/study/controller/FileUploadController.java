package cn.itcast.study.controller;

import cn.itcast.study.service.FileHandleService;
import cn.itcast.study.utils.ReturnResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileUploadController {
    private Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    @Autowired
    private FileHandleService fileHandleService;

    /**
     * 文件上传
     * @param request
     * @param file
     * @return
     */
    @RequestMapping(value = "/fileUpload",method = RequestMethod.POST)
    public ReturnResult fileUpload(HttpServletRequest request, @RequestParam("fileName") MultipartFile file){
        logger.info("图片上传大小size:{}",file.getSize());
        return fileHandleService.fileUpload(request,file);
    }
    //文件上传
    @RequestMapping(value = "/fileUpload2", method = RequestMethod.POST)
    public ReturnResult fileUpload2(HttpServletRequest httpServletRequest,
                                  @RequestParam("file") MultipartFile file,
                                  @RequestParam("sessionId")String sessionId,
                                  @RequestParam("fromId")String fromId,
                                  @RequestParam("fileClass")String fileClass) throws IOException {
        //System.out.println(file.getClass());
        logger.info("method: filesUpload param is file【{}】,sessionId【{}】,fromId【{}】,fileClass【{}】", file, sessionId, fromId, fileClass);
        ReturnResult returnInfo = new ReturnResult();
        if (file.isEmpty()) {
            returnInfo.setCode(2001);
            returnInfo.setMsg("file param is empty");
        } else if (checkForm(httpServletRequest)) {
            returnInfo.setCode(2002);
            returnInfo.setMsg("form must include enctype=multipart/form-data");
        } else if (StringUtils.isEmpty(sessionId)) {
            returnInfo.setCode(2003);
            returnInfo.setMsg("sessionId param is empty");
        } else if (StringUtils.isEmpty(fromId)) {
            returnInfo.setCode(2004);
            returnInfo.setMsg("fromId param is empty");
        } else if (checkFileClass(fileClass)) {
            returnInfo.setCode(2005);
            returnInfo.setMsg("fileClass param is wrong");
        } else {
            String fileName = file.getOriginalFilename();
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
            logger.info("method: filesUpload 需要上传文件的格式是【{}】", fileType);
            byte[] fileBytes = file.getBytes();
            logger.info("filesUpload;文件上传大小****fileBytes:{}",fileBytes.length);
            logger.info("filesUpload;文件上传大小size:{}",file.getSize());
            if (fileType.isEmpty()) {
                returnInfo.setCode(2006);
                returnInfo.setMsg("fileType is empty");
            } else {
                try {
                    returnInfo = fileHandleService.fileUpload2(fileBytes, sessionId, fromId, fileClass, fileType);
                } catch (IOException e) {
                    logger.info("method: filesUpload 调用文件上传异常【{}】", e);
                    returnInfo.setCode(2013);
                    returnInfo.setMsg("calling interface abnormal");
                }
            }
        }
        return returnInfo;
    }

    /**
     * 文件下载
     * @param response
     * @return
     */
    @RequestMapping(value = "/fileDownload",method = RequestMethod.GET)
    public ReturnResult fileDownload(HttpServletResponse response){
        ReturnResult result = new ReturnResult();
        try {
            result = fileHandleService.fileDownload(response);
            return null;
        } catch (Exception e) {
            result.setCode(2001);
            result.setMsg("文件下载失败");
            return null;

        }
    }
    private boolean checkForm(HttpServletRequest request) {
        boolean flag = false;
        if (!ServletFileUpload.isMultipartContent(request)) {
            flag = true;
        }
        return flag;
    }

    private boolean checkFileClass(String fileClass) {
        if (StringUtils.isEmpty(fileClass)) {
            return false;
        } else if (!"IMAGE".equals(fileClass)) {
            return false;
        } else if (!"SHORTVIDEO".equals(fileClass)) {
            return false;
        } else if (!"VOICE".equals(fileClass)) {
            return false;
        } else if (!"FILE".equals(fileClass)) {
            return false;
        } else if (!"OTHER".equals(fileClass)) {
            return false;
        } else if (!"ICON".equals(fileClass)) {
            return false;
        }
        return true;
    }
}
