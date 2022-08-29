package com.example.algorithm.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description : 210. 课程表 II
 * @Author : young
 * @Date : 2022-08-26 11:33
 * @Version : 1.0
 **/
public class Test23 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 边
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }
        // 入度
        int[] inDegree = new int[numCourses];

        // [1,0] 0->1
        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }

        // 队列
        Queue<Integer> queue = new LinkedList();
        // 入度为0的先入队
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 开始bfs
        int cnt = 0; // 可用于作为res下标，也可统计个数
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            res[cnt++] = node;
            // 将该节点的临接点全部入度减一
            for (Integer nextNode : adj[node]) {
                inDegree[nextNode]--;
                // 若入度为0 入队
                if (inDegree[nextNode] == 0) {
                    queue.offer(nextNode);
                }
            }
        }

        if (cnt == numCourses) {
            return res;
        } else {
            return new int[0];
        }
    }
}
