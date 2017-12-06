package com.bangtaoche.spider;

import com.bangtaoche.spider.dpage.service.DetailedPageService;
import com.bangtaoche.spider.dpage.service.ListPageSerivce;
import com.bangtaoche.spider.dpage.service.service;
import com.bangtaoche.spider.util.Util;
import java.io.IOException;

/**
 * @author: 李飞
 * @Time: 17-12-4.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class TotalControl {
    public static void main(String[] args) throws IOException, InterruptedException {
        int startMode = Util.getStartMode();
        service service = null;
//        if (startMode==1){
//         service = new ListPageSerivce();
//        }else if (startMode==2){
         service  = new DetailedPageService(Util.getHendDetailedUrlMessageName());
//        }
        service.start();
    }
}
