package com.resource.distribute.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * <p>
 * Description
 * </p>
 * <p>
 *
 * @author lengrongfu
 * @create 2018年01月12日上午8:03
 * @see </P>
 */
@Configuration
public class BeanConfig {

    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.resource.distribute.dao");
        Properties properties = new Properties();
        properties.setProperty("mappers", "com.resource.distribute.dao.OrderDao");
        configurer.setProperties(properties);
        return configurer;
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        // resolver.setDefaultEncoding("UTF-8");
        // resolver.setResolveLazily(true);// resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        // resolver.setMaxInMemorySize(40960);
        resolver.setMaxUploadSize(10 * 1024 * 1024);// 上传文件大小 5M 5*1024*1024
        return resolver;
    }

    @Bean
    @Primary
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource
                .setUrl("jdbc:mysql://"
                        + System.getProperty("db.host")
                        + ":3306/resource_distribute?autoReconnect=true&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&allowMultiQueries=true&useSSL=false");
        dataSource.setUsername(System.getProperty("db.username"));
        dataSource.setPassword(System.getProperty("db.password"));
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }
}
