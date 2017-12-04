package com.bangtaoche.spider.dpage.service;

import com.bangtaoche.spider.dpage.runnables.getPageRunnable;
import com.bangtaoche.spider.messagequeuecll.MessageQueueFactory;
import com.bangtaoche.spider.messagequeuecll.function.Base.Consumer;
import com.bangtaoche.spider.messagequeuecll.function.Base.Producer;
import com.bangtaoche.spider.messagequeuecll.function.MessageInterface.HandMessage;
import com.bangtaoche.spider.messagequeuecll.function.MessageMode;
import com.bangtaoche.spider.util.Util;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: 李飞
 * @Time: 17-12-4.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class DetailedPageService implements service {
    private String HendDetailedUrlMessageName;//获取详细url的地址
    private ExecutorService executorService;
    public DetailedPageService(String HendDetailedUrlMessageName){
        this.HendDetailedUrlMessageName=HendDetailedUrlMessageName;
        executorService = Executors.newFixedThreadPool(Util.getExecutorsConnectionMax());
    }

    public void start(){
        Consumer consumer = MessageQueueFactory.getConsumer(HendDetailedUrlMessageName);
        consumer.startMessage(new HandMessage() {
            @Override
            public void handMessage(String s) {

            }

            @Override
            public void handMessage(Serializable serializable) {
                MessageMode messageMode = (MessageMode) serializable;
                executorService.execute(new getPageRunnable(messageMode,2));
            }
        });

    }
}
