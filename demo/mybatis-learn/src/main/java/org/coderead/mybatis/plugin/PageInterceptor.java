package org.coderead.mybatis.plugin;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author tommy
 * @title: PagePlugin
 * @projectName coderead-mybatis
 * @description: 分页拦截器
 * @date 2020/6/2110:36 AM
 */
@Intercepts(@Signature(type = StatementHandler.class,
        method = "prepare", args = {Connection.class,
        Integer.class}))
public class PageInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //1. 检测当前是否满足分页条件

        // 带上分页参数
        StatementHandler target = (StatementHandler) invocation.getTarget();
        // SQL包 sql、参数、参数映射
        BoundSql boundSql = target.getBoundSql();
        Object parameterObject = boundSql.getParameterObject();

        Page page = null;

        if (parameterObject instanceof Page) {
            page = (Page) parameterObject;
        } else if (parameterObject instanceof Map) {
            page = (Page) ((Map) parameterObject).values().stream().filter(v -> v instanceof Page).findFirst().orElse(null);
        }

        if (page == null) {
            return invocation.proceed();
        }
        // 2.设置总行数
        // select count(0) from (sql);
        page.setTotal(selectCount(invocation));

        // 3.修改原有SQL
        // select * from users offset 0,limit 50
        String newSql= String.format("%s limit %s offset %s", boundSql.getSql(),page.getSize(),page.getOffset());
        SystemMetaObject.forObject(boundSql).setValue("sql",newSql);
        return invocation.proceed();
    }

    private int selectCount(Invocation invocation) throws SQLException {
        int count = 0;
        StatementHandler target = (StatementHandler) invocation.getTarget();
        // SQL包 sql、参数、参数映射
        String countSql = String.format("select count(*) from (%s) as _page", target.getBoundSql().getSql());


        // JDBC
        Connection connection = (Connection) invocation.getArgs()[0];
        PreparedStatement preparedStatement = connection.prepareStatement(countSql);

        target.getParameterHandler().setParameters(preparedStatement);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }
        resultSet.close();
        preparedStatement.close();

        return count;
    }

    //包装  动态代理 静态代理
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
