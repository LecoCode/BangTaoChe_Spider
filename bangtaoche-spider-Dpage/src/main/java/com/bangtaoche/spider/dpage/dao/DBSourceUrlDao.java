package com.bangtaoche.spider.dpage.dao;

import com.bangtaoche.spider.dpage.connection.RedisConnection;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author: 李飞
 * @Time: 17-11-24.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class DBSourceUrlDao {
    private Jedis connection;
    public DBSourceUrlDao(){
        connection = RedisConnection.getConnection();
    }

    public String getUrl(long id) {
        return null;
    }

    public Set<String> getUrlAll(String key) {
        if (connection==null){
            System.out.println("null");
        }
        Set<String> che168 = connection.smembers(key);
        return che168;
    }

}
