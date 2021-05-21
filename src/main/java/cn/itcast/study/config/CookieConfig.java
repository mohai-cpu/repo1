package cn.itcast.study.config;

import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CookieConfig {
    /**
     * spring boot文档https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/reference/htmlsingle/#howto-use-tomcat-legacycookieprocessor 得知，这种域名设置是cookie 版本0的遗留格式，而spring boot 的嵌入式tomcat默认不支持，必须配置
     * LegacyCookieProcessor
     * There was an unexpected error (type=Internal Server Error, status=500).
     * An invalid domain [.localhost.com] was specified for this cookie
     *
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> cookieProcessorCustomizer() {
        return (factory) -> factory.addContextCustomizers(
                (context) -> context.setCookieProcessor(new LegacyCookieProcessor()));
    }

}
