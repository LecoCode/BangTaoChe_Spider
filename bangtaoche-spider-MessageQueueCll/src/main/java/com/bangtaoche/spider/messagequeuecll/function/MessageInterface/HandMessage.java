package com.bangtaoche.spider.messagequeuecll.function.MessageInterface;

import com.bangtaoche.spider.messagequeuecll.function.MessageMode;
import org.apache.activemq.command.ActiveMQObjectMessage;

import java.io.Serializable;

public interface HandMessage {

    void handMessage(String msg);
    void handMessage(MessageMode objmsg);
}
