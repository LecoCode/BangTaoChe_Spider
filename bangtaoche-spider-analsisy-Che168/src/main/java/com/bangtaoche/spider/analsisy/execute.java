package com.bangtaoche.spider.analsisy;

import bangtaoche.spider.beans.conf.AnalsisyConfig;
import bangtaoche.spider.beans.util.PropertiesPathUtil;
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
        absAnalsisyClient analsisy = null;
        AnalsisyConfig config=null;
        if (args.length<2){
            System.out.println("<lstart>or<dstart>  <confPath>");
            System.exit(-1);
        }
        String startMode = args[0];
        if (startMode.equals("lstart")){
            if (args[1]!=null){
                config = PropertiesPathUtil.BuildListAnalsisyConfig(args[1]);
            }else {
                System.out.println("input config path err");
                System.exit(-1);
            }
            analsisy = new ListAnalsisyClient(config.getHand_list_page_message_name(),config.getSend_list_result_message_name());
        }else if (startMode.equals("dstart")){
            if (args[1]!=null){
                config = PropertiesPathUtil.BuildDetailedAnalsisyConfig(args[1]);
            }else {
                System.out.println("input config path err");
                System.exit(-1);
            }
              analsisy = new DetailedAnalsisyClient(config.getHand_detailed_page_message_name(),config.getSend_detailed_result_message_name());
        }else {
            System.out.println("start mode input error(<lstart>or<dstart>)");
            System.exit(-1);
        }

        analsisy.start();
        }
}
