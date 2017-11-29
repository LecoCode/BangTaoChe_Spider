package com.bangtaoche.spider.dpage.service;

import com.bangtaoche.spider.dpage.messagequeue.DocumentMessageQueue;
import com.bangtaoche.spider.dpage.messagequeue.MessageQueue;
import com.bangtaoche.spider.dpage.runnables.getPageRunnable;
import com.bangtaoche.spider.dpage.url.DBsourceURL;
import com.bangtaoche.spider.dpage.url.getUrl;
import com.bangtaoche.spider.util.ThreadLocalClientFactory;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

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
        executorService = Executors.newFixedThreadPool(15);
    }
    public void start() throws IOException, InterruptedException {
        Set<String> urlAll = dBsourceURL.getUrlAll();
        int i=0;
        System.out.println(
                urlAll.size());
        Iterator<String> iterator = urlAll.iterator();
        while (iterator.hasNext()){
            String urls = iterator.next();
            executorService.execute(new getPageRunnable(urls,"che168"));
            System.out.println("添加了"+(i++)+"个线程！");
        }
//        executorService.shutdown();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        PageService pageService = new PageService();
        pageService.start();
    }
}
