package com.bangtaoche.spider.analsisy.service;

import com.bangtaoche.spider.analsisy.list.ListAnalsisyModeChe168;
import com.bangtaoche.spider.messagequeuecll.MessageQueueFactory;
import com.bangtaoche.spider.messagequeuecll.function.Base.Consumer;
import com.bangtaoche.spider.messagequeuecll.function.Base.Producer;
import com.bangtaoche.spider.messagequeuecll.function.CheBean;
import com.bangtaoche.spider.messagequeuecll.function.MessageInterface.HandMessage;
import com.bangtaoche.spider.messagequeuecll.function.MessageMode;

import java.io.Serializable;
import java.util.List;

/**
 * @author: 李飞
 * @Time: 17-11-29.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function: 解析客户端
 */
public class ListAnalsisyClient extends absAnalsisyClient{

    public ListAnalsisyClient(String handlerMessageName, String sendMessageName) {
        super(handlerMessageName, sendMessageName);
    }

    public void start(){
        Consumer handlerMessage = MessageQueueFactory.getConsumer(handlerMessageName);//创建对应消息队列的消费者
        final Producer sendMessage = MessageQueueFactory.getProducer(sendMessageName);
        handlerMessage.startMessage(new HandMessage() {
            private absListAnalsisyMode AnalsisyMode;//解析类
            public void handMessage(String s) {

            }
            public void handMessage(Serializable serializable) {
                MessageMode messageMode = (MessageMode) serializable;
                String sourceID = messageMode.getSourceID();
                if (sourceID.equals("5")){
                    AnalsisyMode = new ListAnalsisyModeChe168();//创建che168的解析类
                    AnalsisyMode.setPageXMl(messageMode.getMode());//将XML传入解析类中
                    List<CheBean> run = AnalsisyMode.run();//开始解析
                    for (CheBean c: run) {//将解析的结果...
                        c.setSourceID("5");
                        sendMessage.sendListCheMessage(c);
                    }
                }
            }
        });
    }
}
