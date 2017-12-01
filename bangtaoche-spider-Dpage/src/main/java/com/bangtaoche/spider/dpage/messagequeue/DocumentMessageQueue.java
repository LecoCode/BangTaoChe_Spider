package com.bangtaoche.spider.dpage.messagequeue;

import com.bangtaoche.spider.messagequeuecll.MessageQueueFactory;
import com.bangtaoche.spider.messagequeuecll.function.Base.Producer;
import com.bangtaoche.spider.messagequeuecll.function.MessageMode;

import java.io.Serializable;

/**
 * @author: 李飞
 * @Time: 17-11-22.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class DocumentMessageQueue implements MessageQueue{

    private Producer producer;
    public DocumentMessageQueue(String QueueName){
        producer = MessageQueueFactory.getProducer(QueueName);
    }

    public void SendMsgObj(MessageMode document){
         producer.sendObjectMessage(document);
    }

}
