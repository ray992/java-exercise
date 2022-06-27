package com.exercise.concurrent;

public class VolatileExample {

    public static void main(String[] args) {
        MyTestThread myTestThread = new MyTestThread();
        myTestThread.start();
        for (;;){
            if (myTestThread.isFlag()){
                System.out.println("input myTestThread");
                break;
            }
        }
    }
}

class MyTestThread extends Thread {

    private volatile boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag =" + flag);
    }
}
