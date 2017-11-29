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

    public static Properties getProperties(String name){
        Properties properties = new Properties();
        try {
            properties.load(Util.class.getClassLoader().getResourceAsStream(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
