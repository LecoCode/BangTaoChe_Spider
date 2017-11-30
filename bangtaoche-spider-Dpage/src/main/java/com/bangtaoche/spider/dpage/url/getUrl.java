package com.bangtaoche.spider.dpage.url;

import com.bangtaoche.spider.util.RedisConnection;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * @author: 李飞
 * @Time: 17-11-24.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class getUrl implements DBsourceURL {
    private Jedis connection;
    public getUrl(){
        connection = RedisConnection.getConnection();
    }
    @Override
    public void setUrl(String url) {

    }

    @Override
    public void setUrlList(List<String> listurl) {

    }

    @Override
    public String getUrl(long id) {
        return null;
    }

    @Override
    public List<String> getUrlList(List<String> ids) {
        return null;
    }

    @Override
    public Set<String> getUrlAll(String key) {
        Set<String> che168 = connection.smembers(key);
        return che168;
    }
}
