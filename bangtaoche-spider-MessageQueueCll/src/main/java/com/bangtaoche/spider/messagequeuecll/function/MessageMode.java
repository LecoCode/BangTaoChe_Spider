package com.bangtaoche.spider.messagequeuecll.function;

import java.io.Serializable;

/**
 * @author: 李飞
 * @Time: 17-11-30.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class MessageMode implements Serializable {

    private String sourceID;
    private String Mode;

    public String getSourceID() {
        return sourceID;
    }

    public void setSourceID(String sourceID) {
        this.sourceID = sourceID;
    }

    public String getMode() {
        return Mode;
    }

    public void setMode(String mode) {
        Mode = mode;
    }

    @Override
    public String toString() {
        return "MessageMode{" +
                "sourceID=" + sourceID +
                '}';
    }
}
