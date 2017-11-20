package com.bangtaoche.spider.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
/**
 * Leco 2017-11-17
 */
public class ConfigConnection {
    private static final String SEPARATOR= File.separator;
    private static final String CONFIG_PATH=".."+SEPARATOR+"Config/MessageQueue/";
    /**
     * 创建配置文件流
     */
    public static InputStream CreateConfigStream(String ConfigName){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(CONFIG_PATH+ConfigName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            new FileNotFoundException("文件名不存在");
        }
        return fis;
    }


}
