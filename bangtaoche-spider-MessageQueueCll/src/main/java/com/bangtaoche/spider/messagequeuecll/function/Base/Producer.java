package com.bangtaoche.spider.messagequeuecll.function.Base;

import com.bangtaoche.spider.messagequeuecll.function.MessageMode;
import com.bangtaoche.spider.messagequeuecll.function.medium.CreateSession;
import com.bangtaoche.spider.messagequeuecll.function.MessageInterface.SendMessage;
import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import java.util.ArrayList;
import java.util.List;

/**
 * 消息生产者
 */
public class Producer implements SendMessage {
    MessageProducer messageProducer;
    CreateSession createSession;
    public Producer(String d){
        createSession = new CreateSession();
        messageProducer = createSession.CreateProduce(d);

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
        } catch (JMSException e) {
            e.printStackTrace();
            new JMSException(">>>>>>>发送消息失败！");
        }
    }
    /**
     * 发送对象
     * @param
     * @throws JMSException
     */
    public void sendObjectMessage(MessageMode messageMode) {
        try {
            ActiveMQObjectMessage objectMessage=createSession.CreateObjectMessage();
            objectMessage.setObject(messageMode);
            messageProducer.send(objectMessage);
        } catch (JMSException e) {
            e.printStackTrace();
            new JMSException(">>>>>>>发送消息失败！");
        }
    }
    //销毁连接
    public void stop(){
        createSession.stop();
    }
    //关闭发送者链接
    public void close(){
        try {
            messageProducer.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Producer producer = new Producer("Topic");
        List<String> s = new ArrayList<String>();
        for (int i = 0; i <10 ; i++) {
            s.add("李飞"+i);
        }producer.sendMessages(s);
    }

}
