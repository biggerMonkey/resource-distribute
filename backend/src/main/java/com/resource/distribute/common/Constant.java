package com.resource.distribute.common;

/**
 * @author huangwenjun
 * @Date 2018年5月21日
 */
public interface Constant {
    interface USER {
        int ADMIN = 1;
        int IS_DELETE = 1;
        int IS_NOT_DELETE = 2;
        int IS_ENABLE = 2;
        int IS_NOT_ENABLE = 1;
    }
    interface PAGE {
        int DEFAULT_PAGE_SIZE = 20;
        int DEFAULT_PAGE_NUM = 1;
    }
    interface ORDER {
        String DEFAULT_SISUATION = "待拨打";
    }
}
