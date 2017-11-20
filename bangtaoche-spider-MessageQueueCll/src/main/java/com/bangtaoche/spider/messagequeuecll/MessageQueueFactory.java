package com.bangtaoche.spider.messagequeuecll;

import com.bangtaoche.spider.messagequeuecll.function.Base.Consumer;
import com.bangtaoche.spider.messagequeuecll.function.Base.Producer;

import javax.jms.JMSException;

public class MessageQueueFactory {

    private static Consumer consumer;
    private static Producer producer;

    //获取消费者
    public static Consumer getConsumer(){
        if (consumer==null){
            consumer = new Consumer();
        }
        return consumer;
    }
    //获取生产者
    public static Producer getProducer(){
        if (producer==null){
            producer = new Producer();
        }
        return producer;
    }

    public static void main(String[] args){
        Producer producer = MessageQueueFactory.getProducer();
        producer.sendMessage("666666666666666666");
    }




}
