package com.bangtaoche.spider.messagequeuecll;


import com.bangtaoche.spider.messagequeuecll.function.CreateSession;
import com.bangtaoche.spider.messagequeuecll.function.HandMessage;

import javax.jms.*;

public class Consumer {
    MessageConsumer messageConsumer;
    HandMessage handMessage;
    Consumer(){
        CreateSession createSession = new CreateSession();
        messageConsumer = createSession.CreateConsumer();
    }


    public void start(final HandMessage handMessage){
        try {
            messageConsumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {

                    try {
                        handMessage.handMessage(((TextMessage)message).getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                        new JMSException(">>>>>>>获取消息失败！");
                    }
                }
            });
        } catch (JMSException e) {
            e.printStackTrace();
            new JMSException("监听失败");
        }
    }

    /**
     * 消费者监听
     *
     * @param args
     */
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        consumer.start(new HandMessage() {
            public void handMessage(String msg) {
                System.out.println(msg);
            }
        });
    }
}
