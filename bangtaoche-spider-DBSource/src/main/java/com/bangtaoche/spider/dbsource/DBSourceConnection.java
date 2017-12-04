package com.bangtaoche.spider.dbsource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author: 李飞
 * @Time: 17-12-4.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class DBSourceConnection {
    private static DruidDataSource dataSource;
    static {
        Properties dbsource_conf = Util.getProperties("dbsource_conf");
        dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dbsource_conf.getProperty("driversClass"));
        dataSource.setUrl(dbsource_conf.getProperty("connectionURL"));
        dataSource.setUsername(dbsource_conf.getProperty("username"));
        dataSource.setPassword(dbsource_conf.getProperty("password"));
        dataSource.setMaxActive(Integer.parseInt(dbsource_conf.getProperty("maxPoolSize")));
        dataSource.setMinIdle(Integer.parseInt(dbsource_conf.getProperty("minPoolSize")));
        dataSource.setQueryTimeout(Integer.parseInt(dbsource_conf.getProperty("queryTimeout")));
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            new SQLException(">>>>>获取连接失败！");
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = DBSourceConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tbl_che168 WHERE id=2");
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        String source_id = resultSet.getString("city_name");
        System.out.println(source_id);
    }
}
