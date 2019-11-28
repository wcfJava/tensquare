package com.tensquare.base;

import com.tensquare.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: BaseApplication
 * @Description: 基础类启动类
 * @Author: wangcunfu
 * @Date: 2019/11/25 21:57
 * @Version: v1.0 文件初始创建
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
    }

    /**
     * @Description: 雪花算法
     * @Date: 2019/11/25 22:04
     * @Author: wangcunfu
     * @Return com.tensquare.util.IdWorker
     */
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
