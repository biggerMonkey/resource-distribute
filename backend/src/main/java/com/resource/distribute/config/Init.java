package com.resource.distribute.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.resource.distribute.common.DB;
import com.resource.distribute.dao.UserDao;

/**
 * @author huangwenjun
 * @Datetime 2017年8月2日
 */
@Component
@Order(value = 1)
public class Init implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Init.class);

    @Autowired
    private UserDao userDao;

    @Override
    public void run(String... arg0) throws Exception {
        String maxJobNo = userDao.getMaxJobNo();
        LOG.info("maxMenuNo=" + maxJobNo);
        if (StringUtils.isEmpty(maxJobNo)) {
            DB.maxUserJobNumber = "100000";
        } else {
            DB.maxUserJobNumber = maxJobNo;
        }
    }
}
