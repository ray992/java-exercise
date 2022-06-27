package com.exercise.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisOperate {

    static Jedis jedis;

    static JedisPool jedisPool;

    static {
        jedis = new Jedis("127.0.0.1", 6379);
    }

    public static void main(String[] args) {
        //jedis.set("a", "1");
        ordinaryPool();
    }

    public void close(){
        jedis.close();
    }

    public static void ordinaryPool(){
        jedisPool = new JedisPool("127.0.0.1", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("c", "2");
        System.out.println(jedis.get("c"));
    }

    //pipeline 把一组命令组装在一起，然后发给redis的服务端执行，然后一次性获得返回的结果


}
