package com.bangtaoche.spider.dpage.connection;

import bangtaoche.spider.beans.data.RedisSourceConfig;
import com.bangtaoche.spider.dpage.coordinator.DpageCoordinator;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @author: 李飞
 * @Time: 17-11-27.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class RedisConnection {
    private static JedisPool jedisPool;
    public static void ini(){
        RedisSourceConfig redConfig = DpageCoordinator.dpageConfig.getRedisSourceConfig();
        jedisPool = new JedisPool(redConfig.getHost(),Integer.parseInt(redConfig.getPort()));
    }

    public static Jedis getConnection(){
        Jedis resource = null;
        if (jedisPool!=null){
            resource = jedisPool.getResource();
        }
        return resource;
    }

    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool("127.0.0.1",6379);
        Jedis resource = jedisPool.getResource();
        List<String> srandmember = resource.srandmember("5", 10);
        for (String s:
             srandmember) {
            System.out.println(s);
        }
    }
}
