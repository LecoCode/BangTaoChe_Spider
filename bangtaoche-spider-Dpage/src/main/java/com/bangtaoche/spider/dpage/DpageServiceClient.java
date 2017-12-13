package com.bangtaoche.spider.dpage;

import bangtaoche.spider.beans.conf.DpageConfig;
import bangtaoche.spider.beans.util.PropertiesPathUtil;
import com.bangtaoche.spider.dpage.coordinator.DpageCoordinator;

/**
 * @author: 李飞
 * @Time: 17-12-7.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function: 页面抓取主方法
 */
public class DpageServiceClient {
    /**
     * 如果是列表页抓取模式，配置文件夹下必须要有dpage_conf.properties、db_conf.properties、redis_conf.properties三个配置文件
     * 他们的作用分别是，配置客户端基本参数、数据库链接配置文件、redis配置文件(列表页的初始URL存在Reids中)
     *
     */
    public static void main(String[] args) {
        //如果输入的参数缺少启动模式、配置文件夹路径则退出程序
        if (args.length<2){
            System.out.println("error: <start mode> <config path>");
            System.exit(-1);
        }
        String startMode=args[0];
        //从配置文件夹中获取所有配置文件名字
        String[] directory = PropertiesPathUtil.getDirectoryFiles(args[1]);
        DpageConfig dpageConfig = null;
        //如果是列表页模式启动
        if (startMode.equals("1")){
            //构建填充配置文件
            dpageConfig= PropertiesPathUtil.BuildListModeDpage(directory);
            //如果输入的启动模式与配置文件中的启动模式不同则退出程序
            if (!dpageConfig.getStartMode().equals(startMode)){
                System.err.println("error: shell input start mode not equals config file input start mode " +
                        ">>>> " +
                        "shell input="+startMode+",file input="+dpageConfig.getStartMode());
                System.exit(-1);
            }
        //如果是详细页模式是启动
        }else if (startMode.equals("2")){
            dpageConfig=PropertiesPathUtil.BuildDetailedModeDpage(directory);
            if (!dpageConfig.getStartMode().equals(startMode)){
                System.err.println("error: shell input start mode not equals config file input start mode " +
                        ">>>> " +
                        "shell input="+startMode+",file input="+dpageConfig.getStartMode());
                System.exit(-1);
            }
        }else {
            System.err.println("error: start mode equals 1 or 2 !");
            System.exit(-1);
        }
        //创建页面抓取客户端并且启动
        new DpageCoordinator(dpageConfig);
    }

}
