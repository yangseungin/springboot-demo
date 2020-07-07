package com.giantdwarf.springbootdemo.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class PostgresRunner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    Logger logger = LoggerFactory.getLogger(PostgresRunner.class);


    @Override
    public void run(ApplicationArguments args) throws Exception {

        try(Connection connection = dataSource.getConnection()){
            logger.info(connection.getMetaData().getURL());
            logger.info(connection.getMetaData().getUserName());
            logger.info(connection.getMetaData().getDriverName());
            System.out.println(dataSource.getClass());

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE account(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY  (id))";
            statement.executeUpdate(sql);

        }
        jdbcTemplate.execute("INSERT INTO account VALUES(2, 'yang')");


    }
}
