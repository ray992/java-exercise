package com.exercise.util;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

/**
 *
 */
public class MurMurHashUtils {

    public static Long hash(String str) {
        HashFunction hashFunction = Hashing.murmur3_128();
        return hashFunction.hashString(str, StandardCharsets.UTF_8).asLong();
    }


    public static Long readUnsignedLong(long value) {
        System.out.println(value);
        if (value >= 0){
            return value;
        }
        return value & Long.MAX_VALUE;
    }

    public static Long hashUnsigned(String key) {
        return readUnsignedLong(hash(key));
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++){
            System.out.println(hashUnsigned("https://www.baidu.com/s?wd=MurmurHash%20java&rsv_spt=1&rsv_iqid=0xc4faea1500072087&issp=1&f=3&rsv_bp=1&rsv_idx=2&ie=utf-8&rqlang=cn&tn=baiduhome_pg&rsv_enter=1&rsv_dl=ts_2&rsv_btype=t&inputT=2474&rsv_t=d2d2ezVZOg4gHiRebmnM7NVLHogGbtiflyY16aOHv3Vo1iEbGCK0RlbHqPMG6ZbOkEnq&rsv_sug3=13&oq=MurmurHash%2520java&rsv_pq=be77e81700151f61&rsv_sug1=9&rsv_sug7=100&rsv_sug2=1&prefixsug=MurmurHash%2520%2520&rsp=2&rsv_sug4=3457" + i));
            //8588 7603 6983 7733 295
            //6285 8035 0533 8235 866
            //2365 8452 0411 2973 08
            //-3198 5043 8529 7670 16
            //8903 5215 9832 5008 792
        }
    }
}
