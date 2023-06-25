package com.exercise.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class BaseThreadPoolExecutor{

    private int maxSize;

    protected ThreadPoolExecutor threadPoolExecutor;


    public BaseThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, int workQueueSize) {
        maxSize = maximumPoolSize + workQueueSize;
        threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new ArrayBlockingQueue<>(workQueueSize), new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.setThreadFactory(new BaseThreadFactory());
    }

    public static void main(String[] args) throws InterruptedException {
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(2, 3, 60, 20);
        ThreadPoolExecutor threadPoolExecutor1 = baseThreadPoolExecutor.threadPoolExecutor;
        for (;;){
            threadPoolExecutor1.execute(new ARunnable());
            //System.out.println("coreSize="+threadPoolExecutor1.getCorePoolSize()+" "+"poolSize="+threadPoolExecutor1.getPoolSize()+" "+"largestPoolSize="+threadPoolExecutor1.getLargestPoolSize()+" "+"maxPoolSize="+threadPoolExecutor1.getMaximumPoolSize()+" "+"activeCount="+threadPoolExecutor1.getActiveCount()+" "+"queue="+threadPoolExecutor1.getQueue().size()+" "+"taskCount="+threadPoolExecutor1.getTaskCount());
            System.out.println("corePoolSize="+threadPoolExecutor1.getCorePoolSize() + "  poolSize=" + threadPoolExecutor1.getPoolSize() + " activeCount="+threadPoolExecutor1.getActiveCount() + "  taskCount=" + threadPoolExecutor1.getTaskCount() + "  completeTaskCount="+ threadPoolExecutor1.getCompletedTaskCount() + " queue=" + threadPoolExecutor1.getQueue().size() + " maxPoolSize="+threadPoolExecutor1.getMaximumPoolSize());
            //TimeUnit.SECONDS.sleep(2);
        }
    }

    private static class ARunnable implements Runnable{

        @Override
        public void run() {
            for (;;){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }

    private class BaseThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setUncaughtExceptionHandler(new BaseUncaughtExceptionHandler());
            return t;
        }
    }

    private class BaseUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            log.error("threadPoolExecutor ---> BaseUncaughtExceptionHandler error",e);
        }
    }
}
