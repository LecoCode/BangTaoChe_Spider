package com.bangtaoche.spider.messagequeuecll.function;

import javax.jms.JMSException;
import java.util.List;

public interface SendMessage {

    void sednM(List<String> message) throws JMSException;

}
