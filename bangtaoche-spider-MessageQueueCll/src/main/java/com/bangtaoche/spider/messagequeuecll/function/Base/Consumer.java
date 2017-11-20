package com.bangtaoche.spider.messagequeuecll.function.Base;


import com.bangtaoche.spider.messagequeuecll.function.medium.CreateSession;
import com.bangtaoche.spider.messagequeuecll.function.MessageInterface.HandMessage;

import javax.jms.*;

public class Consumer {
    MessageConsumer messageConsumer;
    CreateSession createSession;
    public Consumer(){
        createSession = new CreateSession();
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
    //销毁连接
    public void stop(){
        createSession.stop();
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
