package com.exercise.concurrent;

/**
 * @ClassName SynchronizedExample
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/5 下午4:15
 * @Version 1.0
 **/
public class SynchronizedExample {

    public static void main(String[] args) {
        //对象锁
        TestRunnable testRunnable = new TestRunnable();
        Thread t1 = new Thread(testRunnable);
        Thread t2 = new Thread(testRunnable);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println(TestRunnable.getI());
    }
}

class TestRunnable implements Runnable {

    public static int i;

    public static int getI() {
        return i;
    }

    /*@Override
    public synchronized void run() { //在方法上加关键字
        for (int j = 0; j < 100000; j++){
            i++;
        }
    }*/

    @Override
    public void run() {
        synchronized (this){ //代码块加锁，this代表当前对象
            for (int j = 0; j < 100000; j++){
                i++;
            }
        }
    }
}