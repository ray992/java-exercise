package com.exercise.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName InheritableThreadLocalDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/10/26 下午6:22
 * @Version 1.0
 **/
public class InheritableThreadLocalDemo {

    private static InheritableThreadLocal<Integer> integerInheritableThreadLocal = new InheritableThreadLocal<>();

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        System.out.println("=== 主线程 ==="+Thread.currentThread().getName());
        integerInheritableThreadLocal.set(100);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("=== 子线程1 ==="+Thread.currentThread().getName());
                System.out.println(integerInheritableThreadLocal.get());
            }
        });
        integerInheritableThreadLocal.set(200);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("=== 子线程2 ==="+Thread.currentThread().getName());
                System.out.println(integerInheritableThreadLocal.get());
            }
        });
    }
}
