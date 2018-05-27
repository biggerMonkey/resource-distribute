package com.resource.distribute.common;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
public interface Constant {
    interface USER {
        int ADMIN = 1;
        int NOT_ADMIN = 2;
        int IS_DELETE = 1;
        int IS_NOT_DELETE = 2;
        int IS_ENABLE = 2;
        int IS_NOT_ENABLE = 1;
        String TOKEN = "token";
    }
    interface PAGE {
        int DEFAULT_PAGE_SIZE = 20;
        int DEFAULT_PAGE_NUM = 1;
    }
    interface ORDER {
        String DEFAULT_SISUATION = "待拨打";
        String NOT_ACCORD = "不符合";
        Integer SENSITIVE = 2;
        Integer NOT_SENSITIVE = 1;
        String MAIN_CHANGE_NUM_KEY = "notAccordCount";// 主套餐变为备注次数
    }
    interface TIME {
        int SECOND = 1;
        int MINUTE = SECOND * 60;
        int HALF_HOUR = MINUTE * 30;
        int HOUR = MINUTE * 60;
        int DAY = HOUR * 24;
        int oneMinuteMillisecond = 1000 * 30;
        int oneHourMillisecond = 1000 * 3600 * 1;// 一小时的毫秒数
    }
}
