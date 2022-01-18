package com.exercise.algorithm.day;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName SimplifyPath
 * @Description 简化路径
 * @Author yeqiang
 * @Date 2022/1/6 上午10:12
 * @Version 1.0
 **/
public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> deque = new ArrayDeque<String>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                deque.offerLast(name);
            }
        }
        StringBuilder ans = new StringBuilder();
        if (deque.isEmpty()) {
            ans.append('/');
        } else {
            while (!deque.isEmpty()) {
                ans.append('/');
                ans.append(deque.pollFirst());
            }
        }
        return ans.toString();
    }
}
