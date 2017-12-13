package com.bangtaoche.spider.dpage.service;

import bangtaoche.spider.beans.network.MessageMode;
import com.bangtaoche.spider.dpage.coordinator.DpageCoordinator;
import com.bangtaoche.spider.dpage.runnables.PageRunnableImpl;
import com.bangtaoche.spider.messagequeuecll.MessageQueueFactory;
import com.bangtaoche.spider.messagequeuecll.function.Base.Consumer;
import com.bangtaoche.spider.messagequeuecll.function.MessageInterface.HandMessage;

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
    public DetailedPageService(){
        this.HendDetailedUrlMessageName= DpageCoordinator.dpageConfig.getHandDetailedUrl();
        executorService = Executors.newFixedThreadPool(DpageCoordinator.dpageConfig.getPoolMax());
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
                System.out.println(">>>>>>>>>>>>>>URL:"+messageMode.getSourceID());
                executorService.execute(new PageRunnableImpl(messageMode,2));
            }
        });

    }
}
