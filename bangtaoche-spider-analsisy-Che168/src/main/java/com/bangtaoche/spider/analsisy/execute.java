package com.bangtaoche.spider.analsisy;

import com.bangtaoche.spider.analsisy.che168.AnalsisyMode;
import com.bangtaoche.spider.analsisy.service.AnalsisyClient;
import com.bangtaoche.spider.analsisy.service.Util;

/**
 * @author: 李飞
 * @Time: 17-11-29.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class execute {
    public static void main(String[] args) {
            AnalsisyClient analsisyClient = new AnalsisyClient(Util.getAnalsisyMessageName(),Util.getSendResultMessageName());
            analsisyClient.start();
        }


}
