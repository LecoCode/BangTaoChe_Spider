package com.bangtaoche.spider.analsisy.service;

import com.bangtaoche.spider.analsisy.che168.AnalsisyMode;
import com.bangtaoche.spider.messagequeuecll.MessageQueueFactory;
import com.bangtaoche.spider.messagequeuecll.function.Base.Consumer;
import com.bangtaoche.spider.messagequeuecll.function.Base.Producer;
import com.bangtaoche.spider.messagequeuecll.function.CheBean;
import com.bangtaoche.spider.messagequeuecll.function.MessageInterface.HandMessage;
import com.bangtaoche.spider.messagequeuecll.function.MessageMode;

import java.io.Serializable;
import java.lang.instrument.Instrumentation;
import java.util.List;

/**
 * @author: 李飞
 * @Time: 17-11-29.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function: 解析客户端
 */
public class AnalsisyClient {
    private String handlerMessageName;//接收XML消息的地址
    private String sendMessageName;//发送结果消息的地址
    private int  count;
    public AnalsisyClient(String handlerMessageName,String sendMessageName){
        this.handlerMessageName=handlerMessageName;
        this.sendMessageName=sendMessageName;
    }
    public void start(){
        Consumer handlerMessage = MessageQueueFactory.getConsumer(handlerMessageName);//创建对应消息队列的消费者
        final Producer sendMessage = MessageQueueFactory.getProducer(sendMessageName);
        handlerMessage.startMessage(new HandMessage() {
            private absAnalsisyMode AnalsisyMode;//解析类
            public void handMessage(String s) {

            }
            public void handMessage(Serializable serializable) {
                MessageMode messageMode = (MessageMode) serializable;
                String sourceID = messageMode.getSourceID();
                if (sourceID.equals("5")){
                    AnalsisyMode = new AnalsisyMode();//创建che168的解析类
                    AnalsisyMode.setPageXMl(messageMode.getMode());//将XML传入解析类中
                    List<CheBean> run = AnalsisyMode.run();//开始解析
                    for (CheBean c: run) {//将解析的结果...
                        sendMessage.sendListCheMessage(c);
                        System.out.println(++count);
                    }
                }
            }
        });
    }
}
