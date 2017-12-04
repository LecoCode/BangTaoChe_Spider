package com.bangtaoche.spider.dbsource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author: 李飞
 * @Time: 17-11-27.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function: 工具类
 */
public class Util {

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
    private static Properties getPropertie(InputStream in){
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


    public static void main(String[] args) {
    }
}
