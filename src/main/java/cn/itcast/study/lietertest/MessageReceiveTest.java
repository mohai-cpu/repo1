package cn.itcast.study.lietertest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
public class MessageReceiveTest {
    private Logger logger = LoggerFactory.getLogger(MessageReceiveTest.class);
   // @RabbitListener(queues = "q.txx-content-center.sj")
    public void process(String msg){
        logger.info("**********************消息监听生效*************************");
        logger.info("process;消息监听msg:{}",msg);
    }
}
