package com.bangtaoche.spider.analsisy.service;

import com.bangtaoche.spider.analsisy.detailed.DetailedAnalsisyModeChe168;
import com.bangtaoche.spider.analsisy.list.ListAnalsisyModeChe168;
import com.bangtaoche.spider.messagequeuecll.MessageQueueFactory;
import com.bangtaoche.spider.messagequeuecll.function.Base.Consumer;
import com.bangtaoche.spider.messagequeuecll.function.Base.Producer;
import com.bangtaoche.spider.messagequeuecll.function.CheBean;
import com.bangtaoche.spider.messagequeuecll.function.DeTailsCheBean;
import com.bangtaoche.spider.messagequeuecll.function.MessageInterface.HandMessage;
import com.bangtaoche.spider.messagequeuecll.function.MessageMode;

import java.io.Serializable;
import java.util.List;

/**
 * @author: 李飞
 * @Time: 17-12-5.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class DetailedAnalsisyClient extends absAnalsisyClient {
    public DetailedAnalsisyClient(String handlerMessageName, String sendMessageName) {
        super(handlerMessageName, sendMessageName);
    }
    public void start(){
        Consumer handlerMessage = MessageQueueFactory.getConsumer(handlerMessageName);//创建对应消息队列的消费者
        final Producer sendMessage = MessageQueueFactory.getProducer(sendMessageName);
        handlerMessage.startMessage(new HandMessage() {
            private absDetailedAnalsisyMode AnalsisyMode;//解析类
            public void handMessage(String s) {

            }
            public void handMessage(Serializable serializable) {
                MessageMode messageMode = (MessageMode) serializable;
                String sourceID = messageMode.getSourceID();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("URL:"+messageMode.toString());
                if (sourceID.equals("5")){
                    AnalsisyMode = new DetailedAnalsisyModeChe168();//创建che168的解析类
                    AnalsisyMode.setPageXMl(messageMode.getMode());//将XML传入解析类中
                    AnalsisyMode.setPageUrl(messageMode.getPageUrl());
                    DeTailsCheBean run = AnalsisyMode.run();//开始解析
                    System.out.println(run.toString());
                    sendMessage.sendDeTailsCheMessage(run);
                }
            }
        });
    }
}
