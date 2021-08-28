package com.exercise.concurrent;

/**
 * @ClassName SynchronizedExample
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/5 下午4:15
 * @Version 1.0
 **/
public class SynchronizedExample2 {

    public static void main(String[] args) {
        Test2Runnable test2Runnable = new Test2Runnable();
        Test2Runnable test2Runnable1 = new Test2Runnable();
        Thread thread = new Thread(test2Runnable);
        thread.start();
        Thread thread1 = new Thread(test2Runnable1);
        thread1.start();
        while (thread.isAlive() || thread1.isAlive()){

        }
        System.out.println(Test2Runnable.getI());
    }
}

class Test2Runnable implements Runnable {

    public static int i;

    public static int getI() {
        return i;
    }

    @Override
    public void run() {
       method();
    }

    public static void method(){
        synchronized (Test2Runnable.class){ //类锁
            for (int j = 0; j < 100000000; j++){
                i++;
            }
        }
    }
}