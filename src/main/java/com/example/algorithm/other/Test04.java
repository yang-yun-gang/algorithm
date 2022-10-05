package com.example.algorithm.other;

import java.util.HashMap;

/**
 * @Description : 560. 和为 K 的子数组
 * @Author : young
 * @Date : 2022-09-19 12:03
 * @Version : 1.0
 **/
public class Test04 {
    public int subarraySum(int[] nums, int k) {
        int pre = 0, cnt = 0;
        // map存储nums [0,i] 的和, 快速找到pre[i]的值
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i]; // 因为pre[i] = pre[i-1] + nums[i]
            if (map.containsKey(pre - k)) {
                cnt += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return cnt;
    }
}
