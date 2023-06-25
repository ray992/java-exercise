package com.exercise.concurrent;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName InheritableThreadLocalDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/10/26 下午6:22
 * @Version 1.0
 **/
public class TransmittableThreadLocalDemo {

    private static TransmittableThreadLocal<Integer> integerInheritableThreadLocal = new TransmittableThreadLocal<>();

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        System.out.println("=== 主线程 ==="+Thread.currentThread().getName());
        integerInheritableThreadLocal.set(100);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (;;){
                    System.out.println("子线程1:"+integerInheritableThreadLocal.get());
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        integerInheritableThreadLocal.set(200);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (;;){
                    System.out.println("子线程2:"+integerInheritableThreadLocal.get());
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }
}
