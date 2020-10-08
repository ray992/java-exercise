package com.exercise.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName SynchronizedDemo
 * @Description Synchronized关键字的使用
 * @Author yeqiang
 * @Date 2020/10/7 10:10 下午
 * @Version 1.0
 **/
public class SynchronizedDemo {

    public static void main(String[] args) {
        final TicketWindowRunnable ticketWindowRunnable = new TicketWindowRunnable();
        Thread t1 = new Thread(ticketWindowRunnable, "n1");
        Thread t2 = new Thread(ticketWindowRunnable, "n2");
        Thread t3 = new Thread(ticketWindowRunnable, "n3");
        Thread t4 = new Thread(ticketWindowRunnable, "n4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
class TicketWindowRunnable implements Runnable{

    private int index = 1;

    private final static int MAX = 500;

    private final static Object MUTEX = new Object();

    @Override
    public void run() {
        synchronized (MUTEX){
            while (index <= MAX){
                System.out.println(Thread.currentThread().getName() + " 号码: "+ index++);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
