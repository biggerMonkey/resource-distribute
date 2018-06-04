package com.resource.distribute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.resource.distribute.utils.SpringContextUtil;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableTransactionManagement
// @EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class ResourceDistribute {
    public static void main(String[] args) {
        SpringApplication applicationWeb = new SpringApplication(ResourceDistribute.class);
        ApplicationContext contextWeb = applicationWeb.run(args);
        SpringContextUtil.setApplicationContext(contextWeb);
    }
}
