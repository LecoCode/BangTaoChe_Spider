package com.bangtaoche.spider.messagequeuecll.function.conn;

import com.bangtaoche.spider.util.ConfigConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Leco 2017-11-17
 */
public class ActiveMQConnection {
    /*** 用户名*/
    private static  String MESSAGE_QUQUE_USER="";
    /*** 密码*/
    private static  String MESSAGE_QUQUE_PASSWORD="";
    /*** 地址*/
    private static  String MESSAGE_QUQUE_HOST="";
    /*** 端口*/
    private static  String MESSAGE_QUQUE_PROT="";

    private static Properties ActiveConfig;

    private static ConnectionFactory conn;
    //加载配置文件
    static {
        ActiveConfig = new Properties();
        try {
            ActiveConfig.load(ConfigConnection.CreateConfigStream("ActiveConnection.propertie"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        MESSAGE_QUQUE_USER = ActiveConfig.getProperty("MESSAGE_QUQUE_USER");
        MESSAGE_QUQUE_PASSWORD = ActiveConfig.getProperty("MESSAGE_QUQUE_PASSWORD");
        MESSAGE_QUQUE_HOST = ActiveConfig.getProperty("MESSAGE_QUQUE_HOST");
        MESSAGE_QUQUE_PROT = ActiveConfig.getProperty("MESSAGE_QUQUE_PROT");
        conn = new ActiveMQConnectionFactory(MESSAGE_QUQUE_USER,MESSAGE_QUQUE_PASSWORD,getMessageQuqueURL());
    }

    /** 获取消息的连接*/
    public static Connection getActiveMQConnection(){
        Connection connection = null;
        try {
            connection = conn.createConnection();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Test
    public void test() throws JMSException {
        Connection activeMQConnection = getActiveMQConnection();
        activeMQConnection.start();
    }

    /**
     * 停止连接
     * @param connection
     */
    public static void stopConnection(Connection connection){
        try {
            connection.stop();
        } catch (JMSException e) {
            e.printStackTrace();
            new JMSException("关闭连接失败");
        }
    }
    //获取链接url
    private static String getMessageQuqueURL() { return MESSAGE_QUQUE_HOST+":"+MESSAGE_QUQUE_PROT;}

}
