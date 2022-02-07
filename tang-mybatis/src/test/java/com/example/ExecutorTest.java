package com.example;

import com.example.constant.Jdbc;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * @author tcs
 * @date Created in 2022-01-24
 */
public class ExecutorTest {

    private Configuration configuration;
    private Transaction transactional;
    private Connection connection;

    @Before
    public void init() throws SQLException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(CurdTest.class.getResourceAsStream("mybatis-config.xml"));
        configuration = build.getConfiguration();
        connection = DriverManager.getConnection(Jdbc.URL, Jdbc.USERNAME, Jdbc.PASSWORD);
        transactional = new JdbcTransaction(connection);
    }

    @Test
    public void SimpleTest() throws SQLException {
        SimpleExecutor simpleExecutor = new SimpleExecutor(configuration, transactional);
        MappedStatement ms = configuration.getMappedStatement("com.example.BreedMapper.selectById");
        List<Object> objects = simpleExecutor.doQuery(ms, 1451485159803314177L, RowBounds.DEFAULT, SimpleExecutor.NO_RESULT_HANDLER, ms.getBoundSql(1451485159803314177L));
    }
}