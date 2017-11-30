package com.bangtaoche.spider.dpage.runnables;

import com.bangtaoche.spider.dpage.jopo.IP;
import com.bangtaoche.spider.dpage.jopo.MessageMode;
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
    private static final int AccessMode = Util.getAccessMode();
    private String url;
    private getPageMode getPageModel;
    private getIpMode GetIpMode;
    private DocumentMessageQueue documentMessageQueue;
    private MessageMode messageMode;
    public getPageRunnable(MessageMode messageMode){
        this.messageMode=messageMode;
        this.url=messageMode.getMode();
        getPageModel = new getPageMode();
        GetIpMode = new getIpMode();
        documentMessageQueue = new DocumentMessageQueue(messageMode.getSourceID());
    }
    @Override
    public void run() {
        String s = null;
        switch (AccessMode){
            case 1:
                s=getPageMode.get(url);
                break;
            case 2:
                IP ip =GetIpMode.getIP();
                System.out.println("开始处理了："+(++Util.start_count)+"个:"+Thread.currentThread().getId());
                System.out.println("********************************");
                System.out.println("********************************");
                System.out.println(ip.toString());
                System.out.println("********************************");
                System.out.println("********************************");
                s=getPageMode.get(url,ip);
                break;
        }
        System.out.println("处理了完了："+(++Util.end_count)+"个:"+Thread.currentThread().getId());
        if (s!=null){
        if (s.length()>10){
            messageMode.setMode(s);
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
