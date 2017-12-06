package com.bangtaoche.spider.solver.che_detailed;

import com.bangtaoche.spider.messagequeuecll.MessageQueueFactory;
import com.bangtaoche.spider.messagequeuecll.function.Base.Consumer;
import com.bangtaoche.spider.messagequeuecll.function.DeTailsCheBean;
import com.bangtaoche.spider.messagequeuecll.function.MessageInterface.HandMessage;

import java.io.Serializable;
import java.util.logging.Handler;

/**
 * @author: 李飞
 * @Time: 17-12-6.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class DetailedService {
    private Consumer consumer;

    public DetailedService(String handMessageName){
        consumer = MessageQueueFactory.getConsumer(handMessageName);

    }

    public void start(){
        consumer.startMessage(new HandMessage() {
            public void handMessage(String s) {

            }

            public void handMessage(Serializable serializable) {
                DeTailsCheBean deTailsCheBean = (DeTailsCheBean)serializable;
                System.out.println(deTailsCheBean.toString());
            }
        });
    }

    public static void main(String[] args) {
        DetailedService detailedService = new DetailedService("RESULT_DETAILED");
        detailedService.start();
    }
}
