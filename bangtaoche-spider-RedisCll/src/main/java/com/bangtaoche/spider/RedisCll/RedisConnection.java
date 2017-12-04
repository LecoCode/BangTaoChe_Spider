package com.bangtaoche.spider.RedisCll;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: 李飞
 * @Time: 17-11-27.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class RedisConnection {

    static {
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
//        jedisPoolConfig.setp
        JedisPool jedisPool = new JedisPool();
    }



}
