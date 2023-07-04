package com.exercise.algorithm.day;

import sun.security.provider.MD5;
import sun.security.rsa.RSASignature;

import java.util.*;

/**
 * @ClassName TinyURLCodec
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/6/29 10:49 AM
 * @Version 1.0
 **/
public class TinyURLCodec {

    private String prefix = "http://tinyurl.com/";

    private Integer startId = 0;

    private Map<String, String> urlMap = new HashMap<>();


    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String tinyUrl = longUrl;
        String[] urlSegments = longUrl.split("[/]");
        int length = urlSegments.length;
        boolean digitStatus = true;
        if (urlSegments.length > 3){
            String startIdString = urlSegments[3];
            for (char c:startIdString.toCharArray()){
                if (!Character.isDigit(c)){
                    digitStatus = false;
                    break;
                }
            }
        }else {
            digitStatus = false;
        }
        if (length != 4 || !urlSegments[2].equals(prefix) || !digitStatus){
            tinyUrl = prefix + (++startId);
            urlMap.put(tinyUrl, longUrl);
        }
        return tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMap.get(shortUrl);
    }

    public static void main(String[] args) {
        TinyURLCodec tinyURLCodec = new TinyURLCodec();
        List<String> encodeList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
             String encodeString = tinyURLCodec.encode("https://leetcode.com/problems/design-tinyurl-"+i);
             System.out.println(encodeString);
             encodeList.add(encodeString);
        }
        for (String encode:encodeList){
            System.out.println(tinyURLCodec.decode(encode));
        }
    }
}
