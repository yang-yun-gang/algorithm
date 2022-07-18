package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * @Description : 剑指 Offer 45. 把数组排成最小的数
 * @Author : young
 * @Date : 2022-07-18 10:10
 * @Version : 1.0
 **/
public class Test03 {
    public String minNumber(int[] nums) {
        // 把整数都转换为字符串
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // 排序
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            res.append(strs[i]);
        }

        return res.toString();
    }
}
