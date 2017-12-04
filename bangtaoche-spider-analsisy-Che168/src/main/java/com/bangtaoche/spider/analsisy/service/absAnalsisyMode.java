package com.bangtaoche.spider.analsisy.service;

import com.bangtaoche.spider.messagequeuecll.function.CheBean;

import java.util.List;

/**
 * @author: 李飞
 * @Time: 17-11-29.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function: 解析类的抽象类
 */
public abstract class absAnalsisyMode {
    private String pagexml;//需要解析的XML文件
    public absAnalsisyMode setPageXMl(String pagexml){
        this.pagexml=pagexml;
        return this;
    }
    public abstract List<CheBean> run();// 开始解析的抽象方法
}
