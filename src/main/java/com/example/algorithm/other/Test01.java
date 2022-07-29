package com.example.algorithm.other;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description : 快乐数
 * @Author : young
 * @Date : 2022-07-28 9:13
 * @Version : 1.0
 **/
public class Test01 {
    public boolean  isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            // 判断是否出现环
            if (set.contains(n)) {
                return false;
            } else {
                n = cnt(n);
                set.add(n);
            }
        }
        return true;
    }

    private int cnt(int n) {
        int sum = 0;
        while (n > 0) {
            int t = n % 10;
            sum += Math.pow(t, 2);
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Test01 test = new Test01();
        System.out.println(test.isHappy(2));
    }
}
