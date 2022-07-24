package com.example.algorithm.sort;

import java.util.PriorityQueue;

/**
 * @Description : 剑指 Offer 41. 数据流中的中位数
 * @Author : young
 * @Date : 2022-07-14 8:52
 * @Version : 1.0
 **/
public class Test02 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}

class MedianFinder {

    // 小顶堆
    PriorityQueue<Integer> minHeap;

    // 大顶堆
    PriorityQueue<Integer> maxHeap;


    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        if (minHeap.size() == maxHeap.size()) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        return (maxHeap.size() == minHeap.size()) ? (maxHeap.peek() + minHeap.peek()) / 2.0 : maxHeap.peek();
    }
}
