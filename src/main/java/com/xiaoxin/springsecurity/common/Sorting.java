package com.xiaoxin.springsecurity.common;

import java.util.List;

/**
 * @Auther zhangyongxin
 * @date 2018/6/22 下午10:25
 */
public interface Sorting {

    List<Sort> getSorts();

    void addSort(Sort sort);
}
