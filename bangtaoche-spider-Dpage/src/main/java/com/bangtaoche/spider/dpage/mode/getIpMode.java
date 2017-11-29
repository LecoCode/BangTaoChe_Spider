package com.bangtaoche.spider.dpage.mode;

import com.bangtaoche.spider.dpage.jopo.IP;
import com.bangtaoche.spider.util.mySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: 李飞
 * @Time: 17-11-23.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class getIpMode implements IpMode {
    Connection conn;
    public getIpMode(){
        conn = mySQLConnection.getConnection();
    }


    public IP getIP(){
        IP ip = null;
        PreparedStatement preparedStatement =
                null;
        try {
            preparedStatement = conn.prepareStatement("SELECT ip,port FROM db_spider.tbl_ip order by id desc limit 1 ");

        ResultSet resultSet =
                preparedStatement.executeQuery();
        resultSet.next();
            ip = new IP(resultSet.getString("ip"),Integer.parseInt(resultSet.getString("port")));
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
}
