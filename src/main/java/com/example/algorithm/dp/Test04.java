package com.example.algorithm.dp;

/**
 * @Description : 剑指 Offer 42. 连续子数组的最大和
 * @Author : young
 * @Date : 2022-06-28 11:08
 * @Version : 1.0
 **/
public class Test04 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int max = nums[0];
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (a >= 0) {
                a += nums[i];
            } else {
                a = nums[i];
            }
            max = (a > max) ? a : max;
        }

        return max;
    }

    public static void main(String[] args) {
        Test04 test = new Test04();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(test.maxSubArray(nums));
    }

}
