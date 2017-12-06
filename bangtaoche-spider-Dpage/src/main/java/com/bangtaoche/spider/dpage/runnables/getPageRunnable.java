package com.bangtaoche.spider.dpage.runnables;

import com.bangtaoche.spider.dpage.jopo.IP;
import com.bangtaoche.spider.dpage.messagequeue.DocumentMessageQueue;
import com.bangtaoche.spider.dpage.mode.getIpMode;
import com.bangtaoche.spider.dpage.mode.getPageMode;
import com.bangtaoche.spider.messagequeuecll.function.MessageMode;
import com.bangtaoche.spider.util.Util;

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
    private getIpMode GetIpMode;
    private DocumentMessageQueue documentMessageQueue;
    private MessageMode messageMode;

    /**
     *
     * @param messageMode 消息实体
     * @param off 1：创建发送给List解析类的地址，2：创建发送个详细页解析类的地址
     */
    public getPageRunnable(MessageMode messageMode,int off){
        this.messageMode=messageMode;
        this.url=messageMode.getMode();
        GetIpMode = new getIpMode();
        if (off==1){
            documentMessageQueue = new DocumentMessageQueue(Util.getListMessageName());
        }else if (off==2){
            documentMessageQueue = new DocumentMessageQueue(Util.getDetailedMessageName());

        }
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
            messageMode.setPageUrl(url);
            messageMode.setMode(s);
            documentMessageQueue.SendMsgObj(messageMode);
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
