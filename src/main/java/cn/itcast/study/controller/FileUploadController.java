package cn.itcast.study.controller;

import cn.itcast.study.service.FileHandleService;
import cn.itcast.study.utils.ReturnResult;
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
        return fileHandleService.fileUpload(request,file);
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
}
