package cn.itcast.study.groovy

import cn.itcast.study.service.GroovyRule
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class SpringGroovyRule implements GroovyRule {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Override
    public int getType() {
        return GROOVY_SPRING_TYPE;
    }
    @Override
    void printInfo() {
        log.info("这是一段Spring的Groovy代码");
        printInfoHigh();
    }

    void printInfoHigh() {
        log.info("这是一段Spring的Groovy代码的代码");
        log.info("**************************************")
    }
}
