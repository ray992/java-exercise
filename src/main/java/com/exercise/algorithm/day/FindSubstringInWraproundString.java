package com.exercise.algorithm.day;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class FindSubstringInWraproundString {

    public int findSubstringInWraproundString(String p) {
        Deque<Character> orderDeque = new ArrayDeque<>();
        Set<String> childStringSet = new HashSet<>();
        int n = p.length();
        for (int i = 0; i < n; i++){
            char c = p.charAt(i);
            childStringSet.add(String.valueOf(c));
            if (orderDeque.isEmpty()){
                orderDeque.addLast(c);
            }else {
                char lastChar = orderDeque.peekLast();
                for (int r = i + 1; r < n; r++){
                    char c1 = p.charAt(r);
                    if ( 'z' - lastChar < 1){
                        lastChar = 'a' - 1;
                    }
                    if (lastChar == c1 - 1){
                        orderDeque.addLast(c1);
                    }else {
                        StringBuilder childSB = new StringBuilder();
                        while (!orderDeque.isEmpty()){
                            childSB.append(orderDeque.poll());
                            childStringSet.add(childSB.toString());
                        }
                        childStringSet.add(childSB.toString());
                        break;
                    }
                }
            }
        }
        if (!orderDeque.isEmpty()){
            StringBuilder childSB = new StringBuilder();
            while (!orderDeque.isEmpty()){
                childSB.append(orderDeque.poll());
                childStringSet.add(childSB.toString());
            }
            childStringSet.add(childSB.toString());
        }
        return childStringSet.size();
    }

    public int findSubstringInWraproundString2(String p){
        int n = p.length();
        int l = 0;
        int r = 0;
        Deque<Character> deque = new ArrayDeque<>();
        Set<String> childStringSet = new HashSet<>();
        while (l < n){
            char lc = p.charAt(l);
            deque.addLast(lc);
            for (r = l+1 ;r<n; r++){
                char last = deque.peekLast();
                if (last == 'z'){
                    last = 'a' - 1;
                }
                char rc = p.charAt(r);
                if (last != rc - 1){
                    break;
                }
                deque.addLast(rc);
            }
            if (!deque.isEmpty()){
                StringBuilder childSB = new StringBuilder();
                while (!deque.isEmpty()){
                    childSB.append(deque.poll());
                    childStringSet.add(childSB.toString());
                }
                childStringSet.add(childSB.toString());
            }
            l++;
        }
        return childStringSet.size();
    }

    public int findSubstringInWraproundString3(String p){
        char[] cs = p.toCharArray();
        int n = cs.length;
        int[] f = new int[26];
        f[cs[0] - 'a'] = 1;
        int len = 1;
        for (int i = 1; i < n; i++) {
            if ((cs[i] - 'a') == (cs[i - 1] - 'a' + 1) % 26)
                len++;
            else
                len = 1;
            //相同的子串，只会被计算一次，则应当计算最大值
            f[cs[i] - 'a'] = Math.max(f[cs[i] - 'a'], len);
        }
        int ans = 0;
        for (int t : f)
            ans += t;
        return ans;
    }


    public static void main(String[] args) {
        FindSubstringInWraproundString findSubstringInWraproundString = new FindSubstringInWraproundString();
        System.out.println(findSubstringInWraproundString.findSubstringInWraproundString3("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
        System.out.println(findSubstringInWraproundString.findSubstringInWraproundString3("cac"));
        System.out.println(findSubstringInWraproundString.findSubstringInWraproundString3("zab"));
        //System.out.println((char)('z' + 1-'z'));
    }
}
