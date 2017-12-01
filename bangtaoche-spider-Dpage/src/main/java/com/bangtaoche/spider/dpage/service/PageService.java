package com.bangtaoche.spider.dpage.service;

import com.bangtaoche.spider.dpage.runnables.getPageRunnable;
import com.bangtaoche.spider.dpage.url.DBsourceURL;
import com.bangtaoche.spider.dpage.url.getUrl;
import com.bangtaoche.spider.messagequeuecll.function.MessageMode;
import com.bangtaoche.spider.util.Util;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: 李飞
 * @Time: 17-11-22.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class PageService {
    private DBsourceURL dBsourceURL;
    private ExecutorService executorService;
    PageService(){
        dBsourceURL = new getUrl();
        executorService = Executors.newFixedThreadPool(Util.getExecutorsConnectionMax());
    }
    public void start() throws IOException, InterruptedException {
       while (true){
           String[] sourceIDs = Util.getSourceIDs();
           for (String source:
                   sourceIDs) {
               Set<String> urlAll = dBsourceURL.getUrlAll(source);
               int i=0;
               System.out.println(
                       urlAll.size());
               Iterator<String> iterator = urlAll.iterator();
               while (iterator.hasNext()){
                   MessageMode messageMode = new MessageMode();
                   messageMode.setSourceID(source);
                   String urls = iterator.next();
                   messageMode.setMode(urls);
                   executorService.execute(new getPageRunnable(messageMode));
                   System.out.println("添加了"+(i++)+"个线程！");
               }
               urlAll.clear();
           }
       }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        PageService pageService = new PageService();
        pageService.start();
    }
}
