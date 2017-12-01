package com.bangtaoche.spider.util;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author: 李飞
 * @Time: 17-11-28.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class mySQLConnection {
    private static DruidDataSource dataSource;
    static {
        Properties properties = Util.getProperties("db_conf");
        dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getProperty("connectionURL"));
        dataSource.setDriverClassName(properties.getProperty("driversClass"));
        dataSource.setUsername(properties.getProperty("username"));
        dataSource.setPassword(properties.getProperty("password"));
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void close(){
        dataSource.close();
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT ip,port FROM db_spider.tbl_ip order by id desc limit 3 ");
        ResultSet resultSet =
                preparedStatement.executeQuery();

        resultSet.next();
        String ip = resultSet.getString("ip");
        String port = resultSet.getString("port");
        System.out.println(ip+":"+port);
    }

}
