package bangtaoche.spider.beans.util;

import bangtaoche.spider.beans.conf.AnalsisyConfig;
import bangtaoche.spider.beans.conf.DpageConfig;
import bangtaoche.spider.beans.data.DBSourceConfig;
import bangtaoche.spider.beans.data.RedisSourceConfig;

import java.io.*;
import java.util.Properties;

/**
 * @author: 李飞
 * @Time: 17-12-7.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class PropertiesPathUtil {


    /**
     * 从文件夹路径中获取该文件夹中的配置文件
     * @param path
     */
    public static String[] getDirectoryFiles(String path){
        String [] pathFiles;
        File file = new File(path);
            boolean directory = file.exists();
        if (!directory){
            new FileNotFoundException(">>>>>>输入的配置文件目录路径错误！");
            return null;
        }
        File[] files = file.listFiles();
        if (files.length<=0){
            new Exception(">>>>>>该目录为空!");
            return null;
        }
        pathFiles = new String [files.length];
        for (int i = 0; i <files.length ; i++) {
            String absoluteFile = files[i].getAbsolutePath();
            pathFiles[i]= absoluteFile;
        }
        return pathFiles;
    }

    /**
     * 通过File对象获取配置文件
     * @param file
     * @return
     */
    public static Properties getPropertiesConfig(File file){
          Properties properties=null;
        try {
            FileInputStream fin = new FileInputStream(file);
            properties=getProperties(fin);
        } catch (FileNotFoundException e) {
            System.err.println(">>>>>>文件不存在！");
            e.printStackTrace();
        }
          return properties;
    }

    /**
     * 通过路径获取配置文件
     * @param path
     * @return
     */
    public static Properties getPropertiesConfig(String path){
        Properties properties=null;
        try {
            FileInputStream fin = new FileInputStream(path);
            properties=getProperties(fin);
        } catch (FileNotFoundException e) {
            System.err.println(">>>>>>文件不存在！");
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * 获取Properties的配置文件
     * @param in 文件的输入流
     * @return
     */
    public static Properties getProperties(InputStream in){
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            new IOException("加载配置文件错误");
            e.printStackTrace();
        }
      return properties;
    }


    /**
     * 从本地列表页抓取模式配置文件中获取配置信息
     * @param directory 配置文件列表
     * @return 列表页构造器构造的Dpage配置类
     */
    public static DpageConfig BuildListModeDpage(String[] directory){
        DpageConfig dpageConfig;
        String access_mode="";
        String send_listmessage_name="";
        String start_mode="";
        int pool_max= -1;
        String [] list_url_key= null;
        DBSourceConfig dbSourceConfig = new DBSourceConfig();
        RedisSourceConfig redisSourceConfig = new RedisSourceConfig();
        if (directory.length<3){
            System.out.println("error: There is not enough configuration file <durl.properties>  <db.properties>  <redis.properties> ");
            System.exit(-1);
        }
        for (String configPath:
                directory) {
            try {
                if (configPath.contains("dpage_conf.properties")){
                    Properties propertiesConfig = PropertiesPathUtil.getPropertiesConfig(configPath);
                    access_mode = propertiesConfig.getProperty("access_mode");
                    send_listmessage_name = propertiesConfig.getProperty("send_list_message_name");
                    start_mode = propertiesConfig.getProperty("start_mode");
                    pool_max = Integer.parseInt(propertiesConfig.getProperty("pool_max"));
                    list_url_key = propertiesConfig.getProperty("list_url_key").split(",");
            }else if(configPath.contains("db_conf.properties")){
                    Properties propertiesConfig = PropertiesPathUtil.getPropertiesConfig(configPath);
                    dbSourceConfig.setUrl(propertiesConfig.getProperty("connectionURL"));
                    dbSourceConfig.setDriverClassName(propertiesConfig.getProperty("driversClass"));
                    dbSourceConfig.setUsername(propertiesConfig.getProperty("username"));
                    dbSourceConfig.setPassword(propertiesConfig.getProperty("password"));
                    dbSourceConfig.setMaxActive(Integer.parseInt(propertiesConfig.getProperty("maxPoolSize")));
                    dbSourceConfig.setMinIdle(Integer.parseInt(propertiesConfig.getProperty("minPoolSize")));
                    dbSourceConfig.setQueryTimeout(Integer.parseInt(propertiesConfig.getProperty("queryTimeout")));
            }else if (configPath.contains("redis_conf.properties")){
                    Properties propertiesConfig = PropertiesPathUtil.getPropertiesConfig(configPath);
                    redisSourceConfig.setHost(propertiesConfig.getProperty("host"));
                    redisSourceConfig.setPort(propertiesConfig.getProperty("port"));
                    redisSourceConfig.setMaxIdle(Integer.parseInt(propertiesConfig.getProperty("maxIdle")));
                    redisSourceConfig.setMaxWait(Integer.parseInt(propertiesConfig.getProperty("maxWait")));
                    redisSourceConfig.setTestOnBrrorw(Boolean.parseBoolean(propertiesConfig.getProperty("testOnBorrow")));
                    redisSourceConfig.setTestOnReturn(Boolean.parseBoolean(propertiesConfig.getProperty("testOnReturn")));
            }
            }catch (NullPointerException e){
                System.out.println("error: 缺少配置！");
                e.printStackTrace();
                System.exit(-1);
            }
        }
        dpageConfig = new DpageConfig(access_mode,send_listmessage_name,start_mode,pool_max,list_url_key,dbSourceConfig,redisSourceConfig);
        return dpageConfig;
    }

    /**
     * 从本地详细页抓取模式配置文件中获取配置信息
     * @param directory 配置文件列表
     * @return 详细页构造器构造的Dpage配置类
     */
    public static DpageConfig BuildDetailedModeDpage(String[] directory){
        DpageConfig dpageConfig;
        String access_mode="";
        String start_mode="";
        String hand_detailed_url_message_name="";
        String send_detailed_message_name="";
        int pool_max= -1;
        DBSourceConfig dbSourceConfig = new DBSourceConfig();
        if (directory.length<2){
            System.out.println("error: There is not enough configuration file <durl.properties>  <db.properties>");
            System.exit(-1);
        }
        for (String configPath:
                directory) {
            try {
                if (configPath.contains("dpage_conf.properties")){
                    Properties propertiesConfig = PropertiesPathUtil.getPropertiesConfig(configPath);
                    access_mode = propertiesConfig.getProperty("access_mode");
                    hand_detailed_url_message_name = propertiesConfig.getProperty("hand_detailed_url");
                    send_detailed_message_name = propertiesConfig.getProperty("send_detailed_message_name");
                    start_mode = propertiesConfig.getProperty("start_mode");
                    pool_max = Integer.parseInt(propertiesConfig.getProperty("pool_max"));
            }else if(configPath.contains("db_conf.properties")){
                    Properties propertiesConfig = PropertiesPathUtil.getPropertiesConfig(configPath);
                    dbSourceConfig.setUrl(propertiesConfig.getProperty("connectionURL"));
                    dbSourceConfig.setDriverClassName(propertiesConfig.getProperty("driversClass"));
                    dbSourceConfig.setUsername(propertiesConfig.getProperty("username"));
                    dbSourceConfig.setPassword(propertiesConfig.getProperty("password"));
                    dbSourceConfig.setMaxActive(Integer.parseInt(propertiesConfig.getProperty("maxPoolSize")));
                    dbSourceConfig.setMinIdle(Integer.parseInt(propertiesConfig.getProperty("minPoolSize")));
                    dbSourceConfig.setQueryTimeout(Integer.parseInt(propertiesConfig.getProperty("queryTimeout")));
            }
            }catch (NullPointerException e){
            System.out.println("error: 缺少配置！");
            e.printStackTrace();
            System.exit(-1);
            }
        }
        dpageConfig = new DpageConfig(access_mode,hand_detailed_url_message_name,start_mode,send_detailed_message_name,pool_max,dbSourceConfig);
        return dpageConfig;
    }


    public static AnalsisyConfig BuildListAnalsisyConfig(String path){
        Properties propertiesConfig = getPropertiesConfig(path);
        String hand_list_page_message_name = propertiesConfig.getProperty("hand_list_page_message_name");
        String send_list_result_message_name = propertiesConfig.getProperty("send_list_result_message_name");
        AnalsisyConfig analsisyConfig = new AnalsisyConfig();
        analsisyConfig.setSend_list_result_message_name(send_list_result_message_name);
        analsisyConfig.setHand_list_page_message_name(hand_list_page_message_name);
        return analsisyConfig;
    }
    public static AnalsisyConfig BuildDetailedAnalsisyConfig(String path){
        Properties propertiesConfig = getPropertiesConfig(path);
        String hand_detailed_page_message_name = propertiesConfig.getProperty("hand_detailed_page_message_name");
        String send_detailed_result_message_name = propertiesConfig.getProperty("send_detailed_result_message_name");
        AnalsisyConfig analsisyConfig = new AnalsisyConfig();
        analsisyConfig.setSend_detailed_result_message_name(send_detailed_result_message_name);
        analsisyConfig.setHand_detailed_page_message_name(hand_detailed_page_message_name);
        return analsisyConfig;
    }


}
