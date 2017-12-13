package com.bangtaoche.spider.dpage.service;

import bangtaoche.spider.beans.network.MessageMode;
import com.bangtaoche.spider.dpage.coordinator.DpageCoordinator;
import com.bangtaoche.spider.dpage.runnables.PageRunnableImpl;
import com.bangtaoche.spider.dpage.dao.DBSourceUrlDao;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: 李飞
 * @Time: 17-12-4.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class ListPageSerivce  implements service{
    private DBSourceUrlDao dBsourceURLDao;
    private ExecutorService executorService;
    public ListPageSerivce(){
        dBsourceURLDao = new DBSourceUrlDao();
        executorService = Executors.newFixedThreadPool(DpageCoordinator.dpageConfig.getPoolMax());
    }
    public void start(){
        while (true){
            String[] sourceIDs = DpageCoordinator.dpageConfig.getListUrlKey();
            for (String source:
                    sourceIDs) {
                Set<String> urlAll = dBsourceURLDao.getUrlAll(source);
                int i=0;
                System.out.println(
                        urlAll.size());
                Iterator<String> iterator = urlAll.iterator();
                while (iterator.hasNext()){
                    MessageMode messageMode = new MessageMode();
                    messageMode.setSourceID(source);
                    String urls = iterator.next();
                    messageMode.setMode(urls);
                    executorService.execute(new PageRunnableImpl(messageMode,1));
                    System.out.println("添加了"+(i++)+"个线程！");
                }
                urlAll.clear();
            }
        }
    }
}
