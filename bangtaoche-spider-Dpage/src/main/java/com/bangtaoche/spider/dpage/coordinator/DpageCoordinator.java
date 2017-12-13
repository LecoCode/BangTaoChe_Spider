package com.bangtaoche.spider.dpage.coordinator;

import bangtaoche.spider.beans.conf.DpageConfig;
import com.bangtaoche.spider.dpage.connection.DBResourceChe;
import com.bangtaoche.spider.dpage.connection.RedisConnection;
import com.bangtaoche.spider.dpage.service.DetailedPageService;
import com.bangtaoche.spider.dpage.service.ListPageSerivce;
import com.bangtaoche.spider.dpage.service.service;

/**
 * @author: 李飞
 * @Time: 17-12-7.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class DpageCoordinator {

    public static DpageConfig dpageConfig;
    private service service;
    public DpageCoordinator(DpageConfig dpageConfig){
        this.dpageConfig=dpageConfig;
        String startMode = dpageConfig.getStartMode();
        if (startMode.equals("1")){
            Lbus();
        }else if (startMode.equals("2")){
            Dbus();
        }
        service.start();
    }

    public void Lbus(){
        DBResourceChe.ini();
        RedisConnection.ini();
        service = new ListPageSerivce();

    }
    public void Dbus(){
        DBResourceChe.ini();
        service = new DetailedPageService();
    }



}
