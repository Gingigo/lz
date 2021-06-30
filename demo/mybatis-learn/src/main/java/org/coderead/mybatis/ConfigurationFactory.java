package org.coderead.mybatis;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ConfigurationFactory {
    public static Configuration getConfiguration() {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = factoryBuilder.build(StatementHandlerTest.class.getResourceAsStream("/mybatis-config.xml"));

        return factory.getConfiguration();
    }
}