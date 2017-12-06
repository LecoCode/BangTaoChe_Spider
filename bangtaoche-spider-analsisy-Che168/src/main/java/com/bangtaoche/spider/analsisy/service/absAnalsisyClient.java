package com.bangtaoche.spider.analsisy.service;

/**
 * @author: 李飞
 * @Time: 17-12-5.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public abstract class absAnalsisyClient {

    protected String handlerMessageName;//接收XML消息的地址
    protected String sendMessageName;//发送结果消息的地址
    public absAnalsisyClient(String handlerMessageName,String sendMessageName){
        this.handlerMessageName=handlerMessageName;
        this.sendMessageName=sendMessageName;
    }
    public abstract void start();
}
