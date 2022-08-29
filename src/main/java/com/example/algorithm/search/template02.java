package com.example.algorithm.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description : 广度遍历模板 参考练习Test21 Test11 Test23
 * @Author : young
 * @Date : 2022-08-25 15:50
 * @Version : 1.0
 **/
public class template02 {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        // 首先将初始元素入队
        queue.add(1);

        while (!queue.isEmpty()) {
            int n = queue.size();
            // 每次遍历一层
            for (int i = 0; i < n; i++) {
                // 出队一个元素
                Integer item = queue.poll();
                // 判断这个元素的周围
                queue.add(2);
            }
        }
    }
}
