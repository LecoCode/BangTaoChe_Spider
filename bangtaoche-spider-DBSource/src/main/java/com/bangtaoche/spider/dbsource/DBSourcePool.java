package com.bangtaoche.spider.dbsource;

import bangtaoche.spider.beans.data.DBSourceConfig;
import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: 李飞
 * @Time: 17-12-4.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class DBSourcePool {
    private static DruidDataSource dataSource;

    public DBSourcePool(DBSourceConfig config){
        dataSource = new DruidDataSource();
        dataSource.setDriverClassName(config.getDriverClassName());
        dataSource.setUrl(config.getUrl());
        dataSource.setUsername(config.getUsername());
        dataSource.setPassword(config.getPassword());
//        dataSource.setMaxActive(config.getMaxActive());
//        dataSource.setMinIdle(config.getMinIdle());
//        dataSource.setQueryTimeout(config.getQueryTimeout());
    }
    /**
     * 获取数据库连接
     * @return
     */
    private static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            new SQLException(">>>>>获取连接失败！");
        }
        return connection;
    }

    public DBSourceimpl getSourceimpl(){
        return new DBSourceimpl(getConnection());
    }

}
