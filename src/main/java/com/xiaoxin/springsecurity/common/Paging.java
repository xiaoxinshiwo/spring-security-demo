package com.xiaoxin.springsecurity.common;

import java.util.List;

/**
 * @Auther zhangyongxin
 * @date 2018/6/22 下午10:25
 */
public interface Paging {

     int getCurrentPage();

     void setCurrentPage(int currentPage);

     int getPageSize();

     void setPageSize(int pagesize);

     boolean isEnableCount();

     void setEnableCount(boolean enable);
}
