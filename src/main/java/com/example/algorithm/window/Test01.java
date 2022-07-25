package com.example.algorithm.window;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description : 力扣3 无重复字符的最长子串 https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * @Author : young
 * @Date : 2022-07-16 9:26
 * @Version : 1.0
 **/
public class Test01 {
    public int lengthOfLongestSubstring(String s) {
        // 右指针-1表示未开始
        int r = -1;
        int res = 0;
        int n = s.length();
        // 存储当前窗口的字符
        Set<Character> set = new HashSet<>();

        // 从0开始依次作为左指针遍历
        for (int i = 0; i < n; i++) {

            if (i != 0) {
                // 左指针向右移动一格时，删除前面的
                set.remove(s.charAt(i - 1));
            }

            // 不断移动右指针
            while (r + 1 < n && !set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(r + 1));
                r++;
            }

            res = Math.max(res, r - i + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        Test01 test = new Test01();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
    }
}
