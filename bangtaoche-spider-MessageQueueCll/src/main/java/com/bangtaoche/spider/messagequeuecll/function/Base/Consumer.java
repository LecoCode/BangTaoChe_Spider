package com.bangtaoche.spider.messagequeuecll.function.Base;


import com.bangtaoche.spider.messagequeuecll.function.MessageMode;
import com.bangtaoche.spider.messagequeuecll.function.medium.CreateSession;
import com.bangtaoche.spider.messagequeuecll.function.MessageInterface.HandMessage;
import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.*;
import java.io.Serializable;

public class Consumer {
    MessageConsumer messageConsumer;
    CreateSession createSession;
    public Consumer(String d){
        createSession = new CreateSession();
        messageConsumer = createSession.CreateConsumer(d);
    }


    public void startMessage(final HandMessage handMessage){
        try {
            messageConsumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    if (message instanceof ObjectMessage){
                            ActiveMQObjectMessage activeMQObjectMessage = (ActiveMQObjectMessage) message;
                        try {
                            Serializable object = activeMQObjectMessage.getObject();
                            handMessage.handMessage(object);
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }else{
                        try {
                            handMessage.handMessage(((TextMessage)message).getText());
                        } catch (JMSException e) {
                            e.printStackTrace();
                            new JMSException(">>>>>>>获取对象消息失败！");
                        }catch (ClassCastException e){
                            e.printStackTrace();
                            new ClassCastException(">>>>>>>类型转换失败，可能是对象不匹配");
                        }
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

    }
}
