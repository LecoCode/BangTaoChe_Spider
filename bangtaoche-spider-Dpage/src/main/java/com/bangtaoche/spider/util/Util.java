package com.bangtaoche.spider.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author: 李飞
 * @Time: 17-11-27.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class Util {

    public static int start_count;
    public static int end_count;
    public static int mess_count;

    /**
     * 通过项目中的path.properties配置文件获取name对应配置文件的真实地址
     * @param name
     * @return
     */
    public static Properties getProperties(String name){
        Properties propertie1 = null;
        Properties propertie = getPropertie(Util.class.getClassLoader().getResourceAsStream("path.properties"));
            String path = propertie.getProperty(name);
            if (path.equals("")&&path==null){
                new NullPointerException("path配置文件中没有"+name+"这个文件的真实路径!");
            }
        try {
            FileInputStream in = new FileInputStream(path);
            propertie1 = getPropertie(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            new FileNotFoundException("没有这个"+name+"这个配置文件,路径错误");
        }
        return propertie1;
    }

    /**
     * 获取配置文件
     * @param in
     * @return
     */
    public static Properties getPropertie(InputStream in){
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    /**
     * 获取sourceid
     * @return
     */
    public static String[] getSourceIDs(){
        String [] source;
            Properties source_conf = getProperties("source_conf");
            String sourceIDs = source_conf.getProperty("sourceIDs");
            if (!sourceIDs.contains(",")){
                source=new String [1];
                source[0]=sourceIDs;
            }else {
                String[] split = sourceIDs.split(",");
                source = new String[split.length];
                source=split;
            }
        return source;
    }
//message_name
    /**
     * 获取线程池最大线程数
     * @return
     */
    public static int getExecutorsConnectionMax(){
        Properties properties = getProperties("executor_conf");
        String pool_max = properties.getProperty("pool_max");
        return Integer.parseInt(pool_max);
    }

    /**
     * 获取爬虫访问模式
     * 1：本机IP爬
     * 2：代理IP爬
     * @return
     */
    public static int getAccessMode(){
        Properties properties = getProperties("durl_conf");
        String pool_max = properties.getProperty("access_mode");
        return Integer.parseInt(pool_max);
    }

    public static String getListMessageName(){
        Properties properties = getProperties("durl_conf");
        String message_name = properties.getProperty("list_message_name");
        return message_name;
    }
    public static String getDetailedMessageName(){
        Properties properties = getProperties("durl_conf");
        String message_name = properties.getProperty("detailed_message_name");
        return message_name;
    }
    public static String getHendDetailedUrlMessageName(){
        Properties properties = getProperties("durl_conf");
        String message_name = properties.getProperty("hend_detailed_url");
        return message_name;
    }
    public static int getStartMode(){
        Properties properties = getProperties("durl_conf");
        String message_name = properties.getProperty("start_mode");
        return Integer.parseInt(message_name);
    }
    public static void main(String[] args) {
        System.out.println(getAccessMode());
    }

}
