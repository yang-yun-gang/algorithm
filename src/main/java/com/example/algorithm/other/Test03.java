package com.example.algorithm.other;

/**
 * @Description : 283. 移动零
 * @Author : young
 * @Date : 2022-09-15 9:28
 * @Version : 1.0
 **/
public class Test03 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            // 将不等于0的移动至左边
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }

        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
