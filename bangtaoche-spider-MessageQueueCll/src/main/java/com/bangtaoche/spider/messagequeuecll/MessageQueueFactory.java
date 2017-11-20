package com.bangtaoche.spider.messagequeuecll;

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
}
