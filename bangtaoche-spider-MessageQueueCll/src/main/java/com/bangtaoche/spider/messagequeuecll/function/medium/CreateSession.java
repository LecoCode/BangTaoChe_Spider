package com.bangtaoche.spider.messagequeuecll.function.medium;

import com.bangtaoche.spider.messagequeuecll.function.conn.ActiveMQConnection;
import com.bangtaoche.spider.util.ConfigConnection;

import javax.jms.*;
import java.io.IOException;
import java.util.Properties;

/**
 * 中间介质类
 */
public class CreateSession {
    private static Properties properties;
    private static Connection conn;
    private static Session session;
    public CreateSession(){
        properties = new Properties();
        try {
            properties.load(ConfigConnection.CreateConfigStream("Destination.propertie"));
        } catch (IOException e) {
            e.printStackTrace();
            new IOException(">>>>>>>连接消息地址配置文件失败，可能文件不存在");
        }
        conn = ActiveMQConnection.getActiveMQConnection();
        try {
            conn.start();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
            new JMSException(">>>>>>>Session 获取错误！");
        }
    }

    /**
     * 创建生产者
     * @return
     */
    public  MessageProducer CreateProduce(){
        Destination destination = null;
        MessageProducer producer = null;
        try {
            destination = session.createQueue(properties.getProperty("Topic"));
        } catch (JMSException e) {
            e.printStackTrace();
            new JMSException(">>>>>>>创建消息地址失败！可能配置文件中没有Topic这个键");
        }
        try {
            producer = session.createProducer(destination);
        } catch (JMSException e) {
            e.printStackTrace();
            new JMSException(">>>>>>>创建生产者时，连接消息地址失败");
        }
        return producer;
    }

    /**
     * 创建消费者
     * @return
     */
    public  MessageConsumer CreateConsumer(){
        Destination destination = null;
        MessageConsumer consumer = null;
        try {
            destination = session.createQueue(properties.getProperty("Topic"));
        } catch (JMSException e) {
            e.printStackTrace();
            new JMSException(">>>>>>>创建消息地址失败！可能配置文件中没有Topic这个键");
        }
        try {
            consumer = session.createConsumer(destination);
        } catch (JMSException e) {
            e.printStackTrace();
            new JMSException(">>>>>>>创建消费者时，连接消息地址失败");
        }
        return consumer;
    }
    /**
     * 创建消息
     * @return
     */
    public  TextMessage CreateTextMessage(){
        TextMessage textMessage = null;
        try {
            textMessage = session.createTextMessage();
        } catch (JMSException e) {
            e.printStackTrace();
            new JMSException(">>>>>>>创建TextMessage失败！");
        }
        return textMessage;
    }

    //销毁连接
    public void stop(){
        ActiveMQConnection.stopConnection(conn);
    }
    public static void main(String []args) throws JMSException {
        //发送信息
        try {
            CreateSession createSession = new CreateSession();
            MessageProducer messageProducer = createSession.CreateProduce();
            for (int i = 0; i <10 ; i++) {
                TextMessage textMessage = createSession.CreateTextMessage();
                textMessage.setText("李飞是神");
                messageProducer.send(textMessage);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
        //接收信息
        CreateSession session = new CreateSession();
        MessageConsumer messageConsumer = session.CreateConsumer();
        messageConsumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                System.out.println("====");
                try {
                    String text = ((TextMessage) message).getText();
                    System.out.println(text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });


    }

}
