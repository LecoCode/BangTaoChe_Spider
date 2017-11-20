package com.bangtaoche.spider.messagequeuecll;

import com.bangtaoche.spider.messagequeuecll.function.ActiveMQConnection;
import com.bangtaoche.spider.messagequeuecll.function.CreateSession;
import com.bangtaoche.spider.messagequeuecll.function.SendMessage;

import javax.jms.*;
import java.util.ArrayList;
import java.util.List;

public class Producer implements SendMessage {
    MessageProducer messageProducer;
    CreateSession createSession;
    Producer(){
        createSession = new CreateSession();
        messageProducer = createSession.CreateProduce();

    }
    public void sednM(List<String> messages){
        Session session = createSession.getSession();
        try {
            for (String s:messages) {
               TextMessage textMessage=session.createTextMessage();
                textMessage.setText(s);
                messageProducer.send(textMessage);
            }
            messageProducer.close();
        } catch (JMSException e) {
            e.printStackTrace();
            new JMSException(">>>>>>>发送消息失败！");
        }


    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        List<String> s = new ArrayList<String>();
        for (int i = 0; i <10 ; i++) {
            s.add("李飞"+i);
        }producer.sednM(s);
    }

}
