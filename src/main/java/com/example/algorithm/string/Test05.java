package com.example.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 2131. 连接两字母单词得到的最长回文串
 * @Author : young
 * @Date : 2022-08-17 11:18
 * @Version : 1.0
 **/
public class Test05 {
    public int longestPalindrome(String[] words) {
        // 统计串出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int res = 0;
        // 是否存在奇数的单个回文
        boolean flag = false;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String s = entry.getKey();
            // 计算s的回文
            String rev = s.substring(1, 2) + s.substring(0, 1);

            // 若s本身就是回文
            if (s.equals(rev)) {
                int cnt = map.get(s);
                if (cnt % 2 == 1) {
                    // s出现奇数次
                    flag = true;
                    cnt--;
                }
                res += cnt * 2;
            } else {
                // 否则，和回文对组成对数（为s和rev出现次数的最小值）
                if (map.containsKey(rev)) {
                    // 由于后续遍历到回文 会重复 所以乘2
                    res += Math.min(map.get(s), map.get(rev)) * 2;
                }
            }
        }

        if (flag) {
            res += 2;
        }

        return res;
    }

    public static void main(String[] args) {
        Test05 test = new Test05();
        String[] strings = new String[]{"lc","cl","gg"};
        System.out.println(test.longestPalindrome(strings));
    }
}
