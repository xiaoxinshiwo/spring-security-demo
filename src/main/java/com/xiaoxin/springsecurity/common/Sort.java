package com.xiaoxin.springsecurity.common;

import java.io.Serializable;

/**
 * @Auther zhangyongxin
 * @date 2018/6/22 下午10:24
 */
public class Sort implements Serializable {

        private static final long serialVersionUID = 7739709965769082011L;
        private static final String DEFAULT_PREFIX = "p";
        private static final String SQL_DOT = ".";
        private String orderField;
        private OrderType orderType = OrderType.ASC;
        private boolean enablePrefix = true;

        private Sort() {
        }

        private Sort(String orderField, OrderType orderType, boolean enablePrefix) {
            assert orderField != null;
            this.orderField = orderField;
            this.orderType = orderType;
            this.enablePrefix = enablePrefix;
        }


        private Sort(String orderField) {
            this(orderField, OrderType.ASC, true);
        }

        public static Sort valueOf(String sortString) {

            return new Sort(sortString);
        }

        public static Sort valueOf(String sortKey, OrderType orderType) {
            return new Sort(sortKey, orderType, true);
        }

        public static Sort valueOf(String sortKey, OrderType orderType, boolean enablePrefix) {
            return new Sort(sortKey, orderType, enablePrefix);
        }

        public String getOrderField() {
            if (orderField.contains(SQL_DOT) || !enablePrefix) {
                return orderField;
            } else {
                return DEFAULT_PREFIX + SQL_DOT + orderField;
            }
        }

        public void setOrderField(String orderField) {
            this.orderField = orderField;
        }

        public OrderType getOrderType() {
            return orderType;
        }

        public void setOrderType(OrderType orderType) {
            this.orderType = orderType;
        }

        public boolean isEnablePrefix() {
            return enablePrefix;
        }

        public void setEnablePrefix(boolean enablePrefix) {
            this.enablePrefix = enablePrefix;
        }

        @Override
        public String toString() {
            return getOrderField() + " " + orderType;
        }
}
