package com.bangtaoche.spider.dpage.messagequeue;

import java.io.Serializable;

/**
 * @author: 李飞
 * @Time: 17-11-23.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public interface MessageQueue {
    void SendMsgObj(Serializable document);
}
