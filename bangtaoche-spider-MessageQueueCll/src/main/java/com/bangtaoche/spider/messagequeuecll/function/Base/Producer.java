package com.bangtaoche.spider.messagequeuecll.function.Base;

import com.bangtaoche.spider.messagequeuecll.function.conn.ActiveMQConnection;
import com.bangtaoche.spider.messagequeuecll.function.medium.CreateSession;
import com.bangtaoche.spider.messagequeuecll.function.MessageInterface.SendMessage;

import javax.jms.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 消息生产者
 */
public class Producer implements SendMessage {
    MessageProducer messageProducer;
    CreateSession createSession;
    public Producer(){
        createSession = new CreateSession();
        messageProducer = createSession.CreateProduce();

    }

    /**
     * 发送单条消息
     * @param message
     * @throws JMSException
     */
    public void sendMessage(String message) {
        try {
            TextMessage textMessage=createSession.CreateTextMessage();
                textMessage.setText(message);
                messageProducer.send(textMessage);
            messageProducer.close();
        } catch (JMSException e) {
            e.printStackTrace();
            new JMSException(">>>>>>>发送消息失败！");
        }
    }

    /**
     * 发送多条消息
     * @param messages
     */
    public void sendMessages(List<String> messages){
        try {
            for (String s:messages) {
               TextMessage textMessage=createSession.CreateTextMessage();
                textMessage.setText(s);
                messageProducer.send(textMessage);
            }
            messageProducer.close();
        } catch (JMSException e) {
            e.printStackTrace();
            new JMSException(">>>>>>>发送消息失败！");
        }


    }
    //销毁连接
    public void stop(){
        createSession.stop();
    }
    public static void main(String[] args) {
        Producer producer = new Producer();
        List<String> s = new ArrayList<String>();
        for (int i = 0; i <10 ; i++) {
            s.add("李飞"+i);
        }producer.sendMessages(s);
    }

}
