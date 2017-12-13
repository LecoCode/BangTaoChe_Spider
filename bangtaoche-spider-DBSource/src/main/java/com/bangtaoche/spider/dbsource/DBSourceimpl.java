package com.bangtaoche.spider.dbsource;

import bangtaoche.spider.beans.data.DBSourceConfig;
import bangtaoche.spider.beans.data.IP;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: 李飞
 * @Time: 17-12-6.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class DBSourceimpl extends DBSourceimplBase implements DBSourceDao {

    protected DBSourceimpl(Connection conn) {
        super(conn);
    }

    public IP getIP() {
        IP ip = new IP();
        try {
            ResultSet tbl_ip = Select("db_spider.tbl_ip order by id desc limit 1", "ip,port");
            tbl_ip.next();
            ip.setIP(tbl_ip.getString("ip"));
            ip.setPort(Integer.parseInt(tbl_ip.getString("port")));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ip;
    }


    public static void main(String[] args) throws InterruptedException {
        DBSourceConfig dbSourceConfig = new DBSourceConfig();
        dbSourceConfig.setDriverClassName("com.mysql.jdbc.Driver");
        dbSourceConfig.setMaxActive(50);
        dbSourceConfig.setMinIdle(1);
        dbSourceConfig.setQueryTimeout(50);
        dbSourceConfig.setUrl("jdbc:mysql://172.16.1.12:58885/db_spider?useUnicode=true&characterEncoding=utf-8");
        dbSourceConfig.setUsername("root");
        dbSourceConfig.setPassword("bangtaodbroot");
        DBSourcePool dbSourceimpl = new DBSourcePool(dbSourceConfig);
        DBSourceimpl sourceimpl = dbSourceimpl.getSourceimpl();
        int count=0;
        while (true){
            Thread.sleep(300);
            IP ip = sourceimpl.getIP();
            System.out.println(ip.toString());
            System.out.println(++count);
            Thread.sleep(10);
        }
    }
}
