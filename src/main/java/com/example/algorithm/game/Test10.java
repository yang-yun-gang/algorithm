package com.example.algorithm.game;

/**
 * @Description : 6132. 使数组中所有元素都等于零
 * @Author : young
 * @Date : 2022-07-31 10:32
 * @Version : 1.0
 **/
public class Test10 {
    public int minimumOperations(int[] nums) {
        int len = nums.length;

        int res = 0;
        while (true) {

            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] != 0) {
                    break;
                } else {
                    cnt++;
                }
            }

            if (cnt == len) {
                return res;
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                if (nums[i] != 0 && nums[i] < min) {
                    min = nums[i];
                }
            }

            for (int i = 0; i < len; i++) {
                if (nums[i] != 0) {
                    nums[i] -= min;
                }
            }

            res++;
        }
    }
}
