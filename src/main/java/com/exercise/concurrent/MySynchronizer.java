package com.exercise.concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @ClassName MySynchronizer
 * @Description 自定义同步器
 * @Author yeqiang
 * @Date 2021/10/20 上午12:37
 * @Version 1.0
 **/
public class MySynchronizer extends AbstractQueuedSynchronizer {

    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }
}
