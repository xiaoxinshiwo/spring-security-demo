package com.xiaoxin.springsecurity.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther zhangyongxin
 * @date 2018/6/22 下午10:23
 */
public class So implements java.io.Serializable, Paging, Sorting {

        private static final long serialVersionUID = -828171499994153332L;

        private int currentPage = 1;
        private int pageSize = PAGESIZE.s.pageSize;
        private boolean enableCount = true;
        private List<Sort> sorts;
        private boolean orderByOnly;


        @Override
        public int getCurrentPage() {
            return currentPage;
        }

        @Override
        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        @Override
        public int getPageSize() {
            return pageSize;
        }

        @Override
        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        @Override
        public boolean isEnableCount() {
            return enableCount;
        }

        @Override
        public void setEnableCount(boolean enableCount) {
            this.enableCount = enableCount;
        }

        @Override
        public List<Sort> getSorts() {
            return sorts;
        }

        public void setSorts(List<Sort> sorts) {
            this.sorts = sorts;
        }

        @Override
        public void addSort(Sort sort) {
            if (sorts == null) {
                sorts = new ArrayList<>();
            }
            sorts.add(sort);
        }

        public enum PAGESIZE {
            xs(5), s(10), m(20), l(30), xl(50), xxl(100), xxxl(1000);
            private int pageSize;

            PAGESIZE(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getPageSize() {
                return pageSize;
            }
        }

        public boolean isOrderByOnly() {
            return orderByOnly;
        }

        public void setOrderByOnly(boolean orderByOnly) {
            this.orderByOnly = orderByOnly;
        }
}
