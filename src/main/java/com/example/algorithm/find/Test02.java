package com.example.algorithm.find;

/**
 * @Description : 剑指 Offer 11. 旋转数组的最小数字
 * @Author : young
 * @Date : 2022-07-30 11:30
 * @Version : 1.0
 **/
public class Test02 {
    // 暴力 找到第一个下降的值
    public int minArray1(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] < numbers[i]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    // 二分查找 最优解
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) {
                i = m + 1;
            } else if (numbers[m] < numbers[j]) {
                j = m;
            } else {
                j = j - 1;
            }
        }

        return numbers[i];
    }
}
