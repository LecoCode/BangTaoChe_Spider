package com.bangtaoche.spider.analsisy;

import com.bangtaoche.spider.analsisy.service.DetailedAnalsisyClient;
import com.bangtaoche.spider.analsisy.service.ListAnalsisyClient;
import com.bangtaoche.spider.analsisy.service.Util;
import com.bangtaoche.spider.analsisy.service.absAnalsisyClient;

/**
 * @author: 李飞
 * @Time: 17-11-29.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class execute {
    public static void main(String[] args) {
//            ListAnalsisyClient listAnalsisyClient =
//                    new ListAnalsisyClient(Util.getListAnalsisyMessageName(),Util.getListSendResultMessageName());
//            listAnalsisyClient.start();


        absAnalsisyClient analsisy = new DetailedAnalsisyClient(Util.getDetailedAnalsisyMessageName(),Util.getDetailedSendResultMessageName());
        analsisy.start();
        }
}
