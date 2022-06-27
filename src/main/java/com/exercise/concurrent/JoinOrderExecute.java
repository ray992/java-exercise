package com.exercise.concurrent;


class MyRunnable implements Runnable {

    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("开始执行："+name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("结束执行："+name);
    }
}

public class JoinOrderExecute {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable("r1"), "th1");
        Thread t2 = new Thread(new MyRunnable("r2"), "th2");
        Thread t3 = new Thread(new MyRunnable("r3"), "th3");
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
    }
}
