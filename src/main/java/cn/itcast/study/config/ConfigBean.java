package cn.itcast.study.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @Title: ConfigBean
 * @ProjectName day02spring
 * @Description: TODO
 * @date 2020/9/28
 */
@ConfigurationProperties(prefix = "my")
@Component
public class ConfigBean {
    private String name;
    private Integer age;
    private Integer number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}

