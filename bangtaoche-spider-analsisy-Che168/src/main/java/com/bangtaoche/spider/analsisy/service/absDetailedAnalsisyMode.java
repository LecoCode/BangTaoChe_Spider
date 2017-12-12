package com.bangtaoche.spider.analsisy.service;

import bangtaoche.spider.beans.che.DeTailsCheBean;

import java.util.List;

/**
 * @author: 李飞
 * @Time: 17-12-5.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public abstract class  absDetailedAnalsisyMode implements AnalsisyInterface {

    protected String pagexml;//需要解析的XML文件
    protected String pageUrl;//需要解析的XML文件
    public void setPageXMl(String pagexml){
        this.pagexml=pagexml;
    }
    public void setPageUrl(String pageUrl){
        this.pageUrl=pageUrl;
    }
    public abstract DeTailsCheBean run();// 开始解析的抽象方法
}
