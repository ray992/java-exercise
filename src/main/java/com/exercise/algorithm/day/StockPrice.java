package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName StockPrice
 * @Description 股票价格波动
 * @Author yeqiang
 * @Date 2022/1/23 上午9:47
 * @Version 1.0
 **/
public class StockPrice {

    Map<Integer, Integer> stockPriceMap = null;
    int maxTimeStamp = 0;
    int maxPrice = Integer.MIN_VALUE;
    int minPrice = Integer.MAX_VALUE;

    PriorityQueue<Integer> pq1 = new PriorityQueue<>();
    PriorityQueue<Integer> pq2 = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public StockPrice() {
        stockPriceMap = new HashMap<>();
    }

    public void update(int timestamp, int price) {
        if (timestamp > maxTimeStamp){
            maxTimeStamp = timestamp;
        }
        if (maxPrice < price){
            maxPrice = price;
        }
        if (minPrice > price){
            minPrice = price;
        }
        pq1.add(price);
        pq2.add(price);
        if (stockPriceMap.containsKey(timestamp)){
            int curPrice = stockPriceMap.get(timestamp);
            pq1.remove(curPrice);
            pq2.remove(curPrice);
            minPrice = pq1.peek();
            maxPrice = pq2.peek();
        }
        stockPriceMap.put(timestamp, price);
    }

    public int current() {
        return stockPriceMap.get(maxTimeStamp);
    }

    public int maximum() {
        return maxPrice;
    }

    public int minimum() {
        return minPrice;
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        //stockPrice.update(1,10);
        stockPrice.update(38,2308);
        System.out.println(stockPrice.maximum());
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.minimum());
        /*stockPrice.update(1,3);
        System.out.println(stockPrice.maximum());
        stockPrice.update(4,2);*/
    }
}
