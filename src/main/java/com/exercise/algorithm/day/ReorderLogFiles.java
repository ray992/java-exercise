package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName ReorderLogFiles
 * @Description 重新排列日志文件
 * @Author yeqiang
 * @Date 2022/5/3 9:33 AM
 * @Version 1.0
 **/
public class ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        String[] res = new String[n];
        List<String> numberLogList = new ArrayList<>();
        List<String> characterLogList = new ArrayList<>();
        for (int i = 0; i < n; i++){
            String curString = logs[i];
            String content = curString.substring(curString.indexOf(" ")+1);
            if (Character.isDigit(content.charAt(0))){
                numberLogList.add(curString);
            }else {
                characterLogList.add(curString);
            }
        }
        int i = 0;
        if (characterLogList.size() > 0){
            Collections.sort(characterLogList, (o1, o2) -> {
                String tag1 = o1.substring(0, o1.indexOf(" "));
                String content1 = o1.substring(o1.indexOf(" ")+1);
                String tag2 = o2.substring(0, o2.indexOf(" "));
                String content2 = o2.substring(o2.indexOf(" ")+1);
                return content1.compareTo(content2) == 0 ? tag1.compareTo(tag2):content1.compareTo(content2);
            });
            for (; i < characterLogList.size(); ++i){
                res[i] = characterLogList.get(i);
            }
        }
        if (numberLogList.size() > 0){
            for (int t = 0; t < numberLogList.size(); t++, i++ ){
                res[i] = numberLogList.get(t);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ReorderLogFiles reorderLogFiles = new ReorderLogFiles();
        System.out.println(Arrays.toString(reorderLogFiles.reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));
        System.out.println(Arrays.toString(reorderLogFiles.reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"})));
    }
}
