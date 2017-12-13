package com.bangtaoche.spider.messagequeuecll.function.MessageInterface;

import java.io.Serializable;

public interface HandMessage {

    void handMessage(String msg);
    void handMessage(Serializable objmsg);
}
