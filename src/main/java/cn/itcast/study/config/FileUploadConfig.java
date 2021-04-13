package cn.itcast.study.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import javax.servlet.MultipartConfigElement;

@Configuration
public class FileUploadConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();

        //factory.setMaxFileSize(1024);
        //单个文件最大50mb
        factory.setMaxFileSize(DataSize.of(50, DataUnit.MEGABYTES)); //KB,MB
        /// 设置总上传数据总大小100mb
        factory.setMaxRequestSize(DataSize.of(100,DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }
}
