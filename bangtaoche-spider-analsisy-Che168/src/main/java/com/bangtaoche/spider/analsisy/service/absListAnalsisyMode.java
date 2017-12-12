package com.bangtaoche.spider.analsisy.service;


import bangtaoche.spider.beans.che.CheBean;

import java.util.List;

/**
 * @author: 李飞
 * @Time: 17-11-29.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function: 解析类的抽象类
 */
public abstract class absListAnalsisyMode implements AnalsisyInterface{
    protected String pagexml;//需要解析的XML文件
    public void setPageXMl(String pagexml){
        this.pagexml=pagexml;
    }
    public abstract List<CheBean> run();// 开始解析的抽象方法
}
