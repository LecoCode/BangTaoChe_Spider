package com.bangtaoche.spider.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ScanResult;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * @author: 李飞
 * @Time: 17-11-27.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class RedisConnection {
    private static JedisPool jedisPool;
    static {
        Properties properties =Util.getProperties("redis.properties");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPool = new JedisPool(jedisPoolConfig,properties.getProperty("redis.ip"), Integer.parseInt(properties.getProperty("redis.port")));
    }

    public static Jedis getConnection(){
        Jedis resource = null;
        if (jedisPool!=null){
            resource = jedisPool.getResource();
        }
        return resource;
    }
    public static void main(String[] args) throws FileNotFoundException {
      RedisConnection redisConnection = new RedisConnection();
        Jedis connection = redisConnection.getConnection();
        Set<String> dd=new HashSet<>();
        for (int i = 0; i <6977 ; i++) {
            List<String> che168 = connection.srandmember("che168", 1);
            String s = che168.get(0);
            dd.add(s);
        }
        System.out.println(dd.size());
    }
}
