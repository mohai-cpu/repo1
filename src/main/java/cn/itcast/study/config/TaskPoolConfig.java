package cn.itcast.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 *  线程池
 */
@Configuration
@EnableAsync
public class TaskPoolConfig {
    @Bean("taskExecutor")
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //是在不超时情况下，保持活跃的最少线程数
        taskExecutor.setCorePoolSize(5);
        //可以创建的最大线程数
        taskExecutor.setMaxPoolSize(25);
        //队列中最大的数目
        taskExecutor.setQueueCapacity(200);
        //线程空闲后的最大存活时间
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setThreadNamePrefix("my-task--");
        //调度器shutdown被调用时等待当前被调度的任务完成
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        //等待时长
        taskExecutor.setAwaitTerminationSeconds(60);
        return taskExecutor;
    }
}
