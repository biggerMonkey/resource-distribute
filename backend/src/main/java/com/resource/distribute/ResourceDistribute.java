package com.resource.distribute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.resource.distribute.utils.SpringContextUtil;

/**
 * Hello world!
 *
 */
@SpringBootApplication
// @EnableTransactionManagement
public class ResourceDistribute {
    public static void main(String[] args) {
        SpringApplication applicationWeb = new SpringApplication(ResourceDistribute.class);
        ApplicationContext contextWeb = applicationWeb.run(args);
        SpringContextUtil.setApplicationContext(contextWeb);
    }
}
