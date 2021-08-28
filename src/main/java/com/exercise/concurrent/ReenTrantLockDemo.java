package com.exercise.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReenTrantLockDemo
 * @Description 显示lock操作
 * @Author yeqiang
 * @Date 2021/8/5 下午3:20
 * @Version 1.0
 **/
public class ReenTrantLockDemo {

    //private final Lock lock = new ReentrantLock(true); //公平锁
    private final Lock lock = new ReentrantLock(); //非公平锁 synchronized也是

    private int value;

    public int get(){
        lock.lock();
        try {
            return value;
        }finally {
            lock.unlock();;
        }
    }

    public void add(){
        lock.lock();
        try {
            value = 1;
            get(); //已经获得加锁操作，此时lock是可以再次加锁，即可重入的。如果lock是不可重入，则此时在这里被阻塞
        }finally {
            lock.unlock();
        }
    }
}
