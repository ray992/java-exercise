package com.exercise.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName InterruptDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/5 下午2:47
 * @Version 1.0
 **/
public class InterruptDemo {

    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(5000);
            myThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//interrupt()方法有两个作用，一个是将线程的中断状态置位(中断状态由false变成true)；另一个则是：让被中断的线程抛出InterruptedException异常。

class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < Integer.MAX_VALUE; i++){
                if (this.isInterrupted()){
                    System.out.println("should be stopped and exit");
                    throw  new InterruptedException(); //清除中断状态
                }
                System.out.println("i= "+i);
            }
            System.out.println("thread has been stopped");
        }catch (InterruptedException interruptedException){
            Thread.currentThread().interrupt(); //重新中断该线程
        }
    }
}
