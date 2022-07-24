package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * @Description : 剑指 Offer 61. 扑克牌中的顺子
 * @Author : young
 * @Date : 2022-07-23 8:58
 * @Version : 1.0
 **/
public class Test04 {
    public boolean isStraight(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        // 找到非0的最小值
        int i = 0;
        while (i < len && nums[i] == 0) i++;

        // 判重
        int j = i;
        while (j < len - 1) {
            if (nums[j] == nums[j + 1]) return false;
            j++;
        }

        return nums[len - 1] - nums[i] < 5;
    }
}
