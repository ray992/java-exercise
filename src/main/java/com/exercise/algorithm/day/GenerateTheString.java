package com.exercise.algorithm.day;

public class GenerateTheString {

    char[] initChars = new char[26];

    {
        char c = 'a';
        for (int i = 0; i < 26; i++){
            initChars[i] = (char) (c + i);
        }
    }

    public String generateTheString(int n) {
       StringBuilder stringBuilder = new StringBuilder();
       if (n <= 26){
           for (int i = 0; i < n; i++){
               stringBuilder.append(initChars[i]);
           }
       }else {
           if ((n & 1) == 0){
               for (int i = 0; i < 26; i++){
                   stringBuilder.append(initChars[i]);
               }
               for (int i = 26; i < n; i++){
                   stringBuilder.append(initChars[0]);
               }
           }else {
              int i = 0;
              while (i < n){
                  stringBuilder.append(initChars[0]);
                  i++;
              }
           }
       }
       return stringBuilder.toString();
    }

    public static void main(String[] args) {
        GenerateTheString generateTheString = new GenerateTheString();
        System.out.println(generateTheString.generateTheString(30));
    }
}
