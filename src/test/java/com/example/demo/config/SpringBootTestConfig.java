package com.example.demo.config;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class SpringBootTestConfig
{
    @Value("${sql.datasource.driver-class-name}")
    private String dbDriver;

    @Value("${sql.datasource.url}")
    private String dbUrl;

    @Value("${sql.datasource.username}")
    private String userName;

    @Value("${sql.datasource.password}")
    private String password;

    @Value("${sql.datasource.port}")
    private String port;

    @Value("${sql.datasource.server}")
    private String server;

    @Value("${sql.datasource.dbName}")
    private String dbName;

    @Bean
    public SQLServerDataSource dataSource()
    {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(userName);
        ds.setPassword(password);
        ds.setServerName(server);
        ds.setPortNumber(Integer.parseInt(port));
        ds.setDatabaseName(dbName);
        return ds;
    }

}