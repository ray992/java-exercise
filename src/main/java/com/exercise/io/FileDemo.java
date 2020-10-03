package com.exercise.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @ClassName FileDemo
 * @Description File 方法
 * @Author yeqiang
 * @Date 2020/10/3 8:28 下午
 * @Version 1.0
 **/
public class FileDemo {

    /**
    * @Name createFile
    * @Description 创建文件
    * @Date 2020/10/3 8:35 下午
    * @params [fileName]
    * @return void
    **/
    public static void createFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()){
            file.createNewFile();
        }
    }

    /**
    * @Name getFilePermissions
    * @Description 获取文件权限
    * @Date 2020/10/3 8:38 下午
    * @params [file]
    * @return void
    **/
    public static void getFilePermissions(File file){
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());
    }

    /**
    * @Name deleteFile
    * @Description 删除文件
    * @Date 2020/10/3 8:42 下午
    * @params [file]
    * @return void
    **/
    public static void deleteFile(File file){
        if (file.exists()){
            file.delete();
        }
    }

    /**
    * @Name fileTraversal
    * @Description 遍历文件目录
    * @Date 2020/10/3 8:44 下午
    * @params [filePath]
    * @return void 
    **/
    public static void fileTraversal(String filePath){
        File file = new File(filePath);
        if (file.isFile()){
            System.out.println(file);
        }
        File[] files = file.listFiles();
        if (files.length > 0){
            for (File file1:files){
                System.out.println(file1);
            }
        }
    }

    /**
    * @Name filterFileTraversal
    * @Description 遍历某种类型的文件
    * @Date 2020/10/3 9:08 下午
    * @params []
    * @return void
    **/
    public static void filterFileTraversal(String filePath){
        File file = new File(filePath);
        if (file.isDirectory()){
           File[] files = file.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".txt");
                }
            });
           for (File file1:files){
               System.out.println(file1);
           }
        }
    }

    /**
    * @Name pathToFile
    * @Description 使用Path构建文件
    * @Date 2020/10/3 9:53 下午
    * @params []
    * @return void
    **/
    public static void pathToFile(){
        Path path = Paths.get("/Users/yeqiang/test.txt");
        System.out.println(path);
        URI uri = path.toUri();
        System.out.println(uri);
    }

  public static void main(String[] args) throws IOException {
        //createFile("/Users/yeqiang/test.txt");
        //getFilePermissions(new File("/Users/yeqiang/test.txt"));
        //deleteFile(new File("/Users/yeqiang/test.txt"));
        //fileTraversal("/Users/yeqiang");
        //filterFileTraversal("/Users/yeqiang/文档");
        //pathToFile();
    }
}
