package com.bangtaoche.spider.dpage.runnables;

import com.bangtaoche.spider.dpage.jopo.IP;
import com.bangtaoche.spider.dpage.messagequeue.DocumentMessageQueue;
import com.bangtaoche.spider.dpage.mode.getIpMode;
import com.bangtaoche.spider.dpage.mode.getPageMode;
import com.bangtaoche.spider.util.Util;

import java.util.Random;

/**
 * @author: 李飞
 * @Time: 17-11-24.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class getPageRunnable implements Runnable {
    private Random random = new Random();
    private String url;
    private getPageMode getPageModel;
    private getIpMode GetIpMode;
    private DocumentMessageQueue documentMessageQueue;
    public getPageRunnable(String url,String messageName){
        this.url=url;
        getPageModel = new getPageMode();
        GetIpMode = new getIpMode();
        documentMessageQueue = new DocumentMessageQueue(messageName);
    }
    @Override
    public void run() {
        IP ip =GetIpMode.getIP();
        System.out.println("开始处理了："+(++Util.start_count)+"个:"+Thread.currentThread().getId());
        System.out.println("********************************");
        System.out.println("********************************");
        System.out.println(ip.toString());
        System.out.println("********************************");
        System.out.println("********************************");
        String s = getPageMode.get(url,ip);
        System.out.println("处理了完了："+(++Util.end_count)+"个:"+Thread.currentThread().getId());
        if (s!=null){
        if (s.length()>10){
            documentMessageQueue.SendMsgObj(s);
            System.out.println("发送了："+(++Util.mess_count)+"个");
        }
        }
        if (!Thread.interrupted()){
            Thread.interrupted();

        }
    }

    public static void main(String[] args) {
    }
}
