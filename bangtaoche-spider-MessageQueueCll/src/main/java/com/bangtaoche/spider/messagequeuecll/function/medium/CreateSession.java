package com.bangtaoche.spider.messagequeuecll.function.medium;

import com.bangtaoche.spider.util.ConfigConnection;
import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.*;
import java.io.IOException;
import java.util.Properties;

/**
 * 中间介质类
 */
public class CreateSession {
    private static Connection conn;
    private static Session session;
    public CreateSession(){
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
    public  MessageProducer CreateProduce(String d){
        Destination destination = null;
        MessageProducer producer = null;
        try {
            destination = session.createQueue(d);
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
    public  MessageConsumer CreateConsumer(String d){
        Destination destination = null;
        MessageConsumer consumer = null;
        try {
            destination = session.createQueue(d);
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
    /**
     * 创建消息
     * @return
     */
    public  ActiveMQObjectMessage CreateObjectMessage(){
        ActiveMQObjectMessage textMessage = null;
        try {
            textMessage = (ActiveMQObjectMessage) session.createObjectMessage();
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
//    public static void main(String []args) throws JMSException {
//        //发送信息
//        try {
//            CreateSession createSession = new CreateSession();
//            MessageProducer messageProducer = createSession.CreateProduce("Topic");
//            for (int i = 0; i <10 ; i++) {
//                TextMessage textMessage = createSession.CreateTextMessage();
//                textMessage.setText("李飞是神");
//                messageProducer.send(textMessage);
//            }
//        } catch (JMSException e) {
//            e.printStackTrace();
//        }
//        //接收信息
//        CreateSession session = new CreateSession();
//        MessageConsumer messageConsumer = session.CreateConsumer("Topic");
//        messageConsumer.setMessageListener(new MessageListener() {
//            public void onMessage(Message message) {
//                System.out.println("====");
//                try {
//                    String text = ((TextMessage) message).getText();
//                    System.out.println(text);
//                } catch (JMSException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//
//    }

}
