package com.example.algorithm.tmp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * @Description : 美团8.20 寻找点
 * @Author : young
 * @Date : 2022-08-20 10:23
 * @Version : 1.0
 **/
public class Test06 {

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] gps = new int[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                gps[i][j] = sc.nextInt();
            }
        }

        int[] des = new int[3];
        for (int i = 0; i < 3; i++) {
            des[i] = sc.nextInt();
        }

        Map<Node, Integer> map = new HashMap<>();
        for (int k = 0; k < gps.length; k++) {
            int x = gps[k][0];
            int y = gps[k][1];
            int d = des[k];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 计算曼哈顿距离
                    int curD = curculate(x, y, i, j);
                    if (d == curD) {
                        // 不知道怎么存i j
                        
                    }
                }
            }
        }
    }

    private static int curculate(int x, int y, int a, int b) {
        return Math.abs(x - a) + Math.abs(y - b);
    }
}
