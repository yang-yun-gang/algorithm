package com.example.algorithm.game;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description : 数位和相等数对的最大和
 * @Author : young
 * @Date : 2022-07-17 10:53
 * @Version : 1.0
 **/
public class Test06 {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int split = queries[i][1];
            int min_num = queries[i][0];

            int[] temp_nums = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                int length = nums[j].length();
                String s = nums[j].substring(length - split);
                temp_nums[j] = Integer.valueOf(s);
            }
            int[] temp_sort_nums = new int[nums.length];
            for (int k = 0; k < nums.length; k++) {
                temp_sort_nums[k] = temp_nums[k];
            }
            Arrays.sort(temp_sort_nums);
            int t = temp_sort_nums[min_num - 1];
            for (int k = 0; k < nums.length; k++) {
                if (temp_nums[k] == t) {
                    res.add(k);
                    break;
                }
            }
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Test06 test = new Test06();
        String[] nums = new String[]{"24", "37", "96", "04"};
        int[][] queries = new int[][]{{2, 1}, {2, 2}};
        int[] res = test.smallestTrimmedNumbers(nums, queries);
        Arrays.stream(res).forEach((i) -> System.out.println(i));
    }
}
