package cn.itcast.study.service;

import cn.itcast.study.utils.ReturnResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface FileHandleService {
    /**
     * 文件上传
     * @return
     */
    public ReturnResult fileUpload(HttpServletRequest request,MultipartFile file);
    /**
     * 文件上传
     * @return
     */
    public ReturnResult fileUpload2(byte[] fileBytes, String sessionId, String fromId, String fileClass, String fileType) throws IOException;

    /**
     * 文件下载
     * @return
     */
    public ReturnResult fileDownload(HttpServletResponse response) throws Exception;
}
