package com.example.demo.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.*;

@Configuration
public class DataSourceConfiguration extends HikariConfig {

    public static HikariDataSource dataSource;

    @Bean("dataSource")
    @ConfigurationProperties("spring.datasource.hikari")
    public HikariDataSource dataSource(){
        dataSource = DataSourceBuilder.create().type(HikariDataSource.class).build();
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        releaseResultSet(resultSet);
        releaseStatement(statement);
        realeaseConnection(connection);
    }

    public static void realease(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        releaseResultSet(resultSet);
        realeasePreparedStatement(preparedStatement);
        realeaseConnection(connection);
    }

    private static void realeasePreparedStatement(PreparedStatement preparedStatement) {
        try {
            if(preparedStatement != null){
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void releaseStatement(Statement statement) {
        try {
            if(statement != null){
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void releaseResultSet(ResultSet resultSet) {
        try {
            if(resultSet != null){
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void realeaseConnection(Connection connection){
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
