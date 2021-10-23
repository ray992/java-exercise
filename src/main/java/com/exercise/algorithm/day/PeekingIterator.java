package com.exercise.algorithm.day;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @ClassName PeekingIterator
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/10/5 下午3:17
 * @Version 1.0
 **/
public class PeekingIterator implements Iterator<Integer> {

    Deque<Integer> dataDeque = new LinkedList<>();

    public Integer peek() {
        return dataDeque.peekFirst();
    }

    public PeekingIterator(Iterator<Integer> iterator) {
        while (iterator.hasNext()){
            dataDeque.addLast(iterator.next());
        }
    }

    @Override
    public boolean hasNext() {
        return dataDeque.isEmpty();
    }

    @Override
    public Integer next() {
        return dataDeque.pollFirst();
    }
}
