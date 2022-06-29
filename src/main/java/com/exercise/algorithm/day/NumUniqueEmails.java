package com.exercise.algorithm.day;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName NumUniqueEmails
 * @Description 独特的电子邮件地址
 * @Author yeqiang
 * @Date 2022/6/5 10:17 AM
 * @Version 1.0
 **/
public class NumUniqueEmails {

    public int numUniqueEmails(String[] emails) {
        Set<String> filterEmailSet = new HashSet<>();
        for (String email:emails){
            String localName = email.substring(0, email.indexOf("@"));
            if (localName.contains("+")){
                localName = localName.substring(0, localName.indexOf("+"));
            }
            localName = localName.replace(".", "");
            filterEmailSet.add(localName.concat(email.substring(email.indexOf("@"))));
        }
        return filterEmailSet.size();
    }

    public static void main(String[] args) {
        NumUniqueEmails numUniqueEmails = new NumUniqueEmails();
        System.out.println(numUniqueEmails.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
        System.out.println(numUniqueEmails.numUniqueEmails(new String[]{"a@leetcode.com","b@leetcode.com","c@leetcode.com"}));
    }
}
