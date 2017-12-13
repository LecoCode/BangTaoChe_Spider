package bangtaoche.spider.beans.conf;

import bangtaoche.spider.beans.data.DBSourceConfig;
import bangtaoche.spider.beans.data.RedisSourceConfig;

import java.util.Arrays;

/**
 * @author: 李飞
 * @Time: 17-12-7.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class DpageConfig {
    //本地IP爬虫、还是代理IP爬虫*
    private String AccessMode;
    //获取需要下载详细页的URL所存在的MessageQueue地址
    private String HandDetailedUrl;
    //下载好的列表页页面发送给那个MessageQueue地址
    private String SendListPageMessageName;
    //下载好的详细页页面发送给那个MessageQueue地址
    private String SendDetailedPageMessageName;
    //使用什么方式启动：1、下载列表页程序。2、下载详细页程序*
    private String StartMode;
    //需要开启的线程数*
    private int PoolMax;
    //需要从Redis中拿那些渠道列表页URL的Key
    private String[] ListUrlKey;
    //数据库的配置
    private DBSourceConfig DbSourceConfig;
    //redis的配置
    private RedisSourceConfig RedisSourceConfig;

    /**
     * 详细页的配置构造器
     * @param accessMode 爬虫模式
     * @param handDetailedUrl 详细页的url
     * @param sendDetailedPageMessageName 发送page的地址
     * @param startMode 启动模式
     * @param poolMax 最大线程数
     * @param dbSourceConfig 数据库配置
     */

    public DpageConfig(String accessMode, String handDetailedUrl, String sendDetailedPageMessageName, String startMode, int poolMax,DBSourceConfig dbSourceConfig) {
        AccessMode = accessMode;
        HandDetailedUrl = handDetailedUrl;
        SendDetailedPageMessageName = sendDetailedPageMessageName;
        StartMode = startMode;
        PoolMax = poolMax;
        DbSourceConfig = dbSourceConfig;
    }

    /**
     * 下载列表页的配置构造器
     * @param accessMode 爬虫模式
     * @param sendListPageMessageName 发送地址
     * @param startMode 启动模式
     * @param poolMax  最大线程数
     * @param listUrlKey 初始url
     * @param dbSourceConfig 数据库配置
     * @param redisSourceConfig Redis配置
     */
    public DpageConfig(String accessMode, String sendListPageMessageName, String startMode, int poolMax, String[] listUrlKey, DBSourceConfig dbSourceConfig,RedisSourceConfig redisSourceConfig) {
        AccessMode = accessMode;
        SendListPageMessageName = sendListPageMessageName;
        StartMode = startMode;
        PoolMax = poolMax;
        ListUrlKey = listUrlKey;
        DbSourceConfig = dbSourceConfig;
        RedisSourceConfig = redisSourceConfig;
    }

    public String getAccessMode() {
        return AccessMode;
    }

    public String getHandDetailedUrl() {
        return HandDetailedUrl;
    }

    public String getSendListPageMessageName() {
        return SendListPageMessageName;
    }

    public String getSendDetailedPageMessageName() {
        return SendDetailedPageMessageName;
    }

    public String getStartMode() {
        return StartMode;
    }

    public int getPoolMax() {
        return PoolMax;
    }

    public String[] getListUrlKey() {
        return ListUrlKey;
    }

    public DBSourceConfig getDbSourceConfig() {
        return DbSourceConfig;
    }

    public bangtaoche.spider.beans.data.RedisSourceConfig getRedisSourceConfig() {
        return RedisSourceConfig;
    }

    @Override
    public String toString() {
        return "DpageConfig{" +
                "AccessMode='" + AccessMode + '\'' +
                ", HandDetailedUrl='" + HandDetailedUrl + '\'' +
                ", SendListPageMessageName='" + SendListPageMessageName + '\'' +
                ", SendDetailedPageMessageName='" + SendDetailedPageMessageName + '\'' +
                ", StartMode='" + StartMode + '\'' +
                ", PoolMax=" + PoolMax +
                ", ListUrlKey=" + Arrays.toString(ListUrlKey) +
                ", DbSourceConfig=" + DbSourceConfig.toString() +
                ", RedisSourceConfig=" + RedisSourceConfig.toString() +
                '}';
    }
}
