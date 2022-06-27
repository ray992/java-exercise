package com.exercise.algorithm.day;

public class DefangIPaddr {

    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    public static void main(String[] args) {
        DefangIPaddr defangIPaddr = new DefangIPaddr();
        System.out.println(defangIPaddr.defangIPaddr("1.1.1.1"));
    }
}
