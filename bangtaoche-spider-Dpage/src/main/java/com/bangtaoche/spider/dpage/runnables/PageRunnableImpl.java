package com.bangtaoche.spider.dpage.runnables;

import bangtaoche.spider.beans.data.IP;
import bangtaoche.spider.beans.network.MessageMode;
import com.bangtaoche.spider.dbsource.DBSourceDao;
import com.bangtaoche.spider.dpage.coordinator.DpageCoordinator;
import com.bangtaoche.spider.dpage.messagequeue.DocumentMessageQueue;
import com.bangtaoche.spider.dpage.mode.PageModeImpl;
import com.bangtaoche.spider.dpage.connection.DBResourceChe;
import com.bangtaoche.spider.util.Util;

import java.util.Date;

/**
 * @author: 李飞
 * @Time: 17-11-24.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class PageRunnableImpl implements Runnable {
    private int AccessMode;
    private String url;
    private DocumentMessageQueue documentMessageQueue;
    private MessageMode messageMode;
    private DBSourceDao dao;
    /**
     * @param messageMode 消息实体
     * @param startMode 1：创建发送给List解析类的地址，2：创建发送个详细页解析类的地址
     */
    public PageRunnableImpl(MessageMode messageMode, int startMode){
        this.AccessMode= Integer.parseInt(DpageCoordinator.dpageConfig.getAccessMode());
        this.messageMode=messageMode;
        this.url=messageMode.getMode();
        dao = DBResourceChe.getDbSourceimpl();
        if (startMode==1){
            documentMessageQueue =
                    new DocumentMessageQueue(DpageCoordinator.dpageConfig.getSendListPageMessageName());
        }else if (startMode==2){
            documentMessageQueue =
                    new DocumentMessageQueue(DpageCoordinator.dpageConfig.getSendDetailedPageMessageName());
        }
    }
    @Override
    public void run() {
        String s = null;
        Util.outputINFO(url+":>>>>>"+ new Date().toString()+"  准备抓取页面","dpage.log");
        switch (AccessMode){
            case 1:
                s= PageModeImpl.get(url);
                break;
            case 2:
                IP ip =dao.getIP();
                s= PageModeImpl.get(url,ip);
                break;
        }
        Util.outputINFO(url+":>>>>>"+ new Date().toString()+"   页面抓取完毕，准备发送信息","dpage.log");
        System.out.println("处理了完了："+(++Util.end_count)+"个:"+Thread.currentThread().getId());
        if (s!=null){
        if (s.length()>10){
            messageMode.setPageUrl(url);
            messageMode.setMode(s);
            Util.outputINFO(url+":>>>>>"+ new Date().toString()+"    开始发送信息","dpage.log");
            documentMessageQueue.SendMsgObj(messageMode);
            Util.outputINFO(url+":>>>>>"+ new Date().toString()+"    信息发送完毕","dpage.log");
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
