package com.bangtaoche.spider.messagequeuecll;

import com.bangtaoche.spider.messagequeuecll.function.Base.Consumer;
import com.bangtaoche.spider.messagequeuecll.function.Base.Producer;


public class MessageQueueFactory {

    private static Consumer consumer;
    private static Producer producer;

    //获取消费者
    public static Consumer getConsumer(String d){
        if (consumer==null){
            consumer = new Consumer(d);
        }
        return consumer;
    }
    //获取生产者
    public static Producer getProducer(String d){
        if (producer==null){
            producer = new Producer(d);
        }
        return producer;
    }

//    public static void main(String[] args){
//        Producer producer = MessageQueueFactory.getProducer("Topic");
//        producer.sendMessage("666666666666666666");
//        producer.sendMessage("666666666666666666");
//        producer.sendMessage("666666666666666666");
//        producer.sendMessage("666666666666666666");
//        ArrayList<String> list = new ArrayList<String>();
//        list.add("李飞");
//        producer.sendObjectMessage(list);
//
//
//
//
//        //---------------------------------------------
//
//
//        Consumer consumer = MessageQueueFactory.getConsumer("Topic");
//        consumer.startMessage(new HandMessage() {
//            public void handMessage(String msg) {
//                System.out.println("字符串："+msg);
//            }
//
//            public void handMessage(Serializable objmsg) {
//                 ArrayList<String> s = (ArrayList<String>) objmsg;
//                for (String d:
//                     s) {
//                    System.out.println("对象:"+d);
//                }
//            }
//        });
//    }




}
