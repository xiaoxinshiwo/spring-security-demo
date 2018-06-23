package com.xiaoxin.springsecurity.config;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Joiner;
import com.xiaoxin.springsecurity.common.So;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * 排序和分页拦截器
 * @Auther zhangyongxin
 * @date 2018/6/22 下午10:20
 */
@Intercepts(@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))
public class RankAndPagingInterceptor implements Interceptor{
    private static final Joiner SORT_JOINER = Joiner.on(",");

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object paramter = invocation.getArgs()[1];
        if (paramter instanceof So) {
            So so = (So) paramter;
            Page<Object> page = PageHelper.startPage(so.getCurrentPage(), so.getPageSize());
            page.setOrderByOnly(so.isOrderByOnly());
            if (so.getSorts() != null && !so.getSorts().isEmpty()) {
                page.setOrderBy(SORT_JOINER.join(so.getSorts()));
            }
            try {
                return invocation.proceed();
            } finally {
                PageHelper.clearPage();
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
