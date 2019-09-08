package com.javasm.tycrm.service.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ResourceBundle;

/**
 * @ClassName JedisUtil
 * @Description Redis工具类
 * @Author jiafu
 * @Date 2019/9/8 18:12
 * @Version V1.0
 **/

public class JedisUtil {

    private JedisPool jedisPool;

    public  JedisUtil(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("redis");
        String host = (String)resourceBundle.getObject("host");
        int port = Integer.parseInt((String) resourceBundle.getObject("port"));
        jedisPool = new JedisPool(host,port);
    }

    /**
     * 这个是获得Jedis
     *
     * @return
     */
    public Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 释放资源
     */
    public void release(Jedis jedis) {
        //这个表示当前jedis链接 放到我们链接池中  并不是关闭了
        jedis.close();
    }

}
