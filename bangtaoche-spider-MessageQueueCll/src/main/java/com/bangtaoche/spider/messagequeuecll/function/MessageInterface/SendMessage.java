package com.bangtaoche.spider.messagequeuecll.function.MessageInterface;

import javax.jms.JMSException;
import java.util.List;

/**
 * 发送信息的接口
 */
public interface SendMessage {

    void sendMessage(String message) throws JMSException;
    void sendMessages(List<String> message) throws JMSException;

}
