package com.example.algorithm.game;

import java.util.Arrays;

/**
 * @Description : 数组能形成多少数对
 * @Author : young
 * @Date : 2022-07-17 10:43
 * @Version : 1.0
 **/
public class Test05 {
    public int[] numberOfPairs(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int couple = 0;
        int i = 0;
        while (i < len) {
            if (i + 1 < len && nums[i] == nums[i + 1]) {
                i += 2;
                couple++;
            } else {
                i++;
            }
        }

        return new int[]{couple, len - couple * 2};
    }
}
