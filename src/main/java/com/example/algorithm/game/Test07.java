package com.example.algorithm.game;

import java.util.HashMap;

/**
 * @Description : 周赛303 给你一个由小写英文字母组成的字符串 s ，请你找出并返回第一个出现 两次 的字母
 * @Author : young
 * @Date : 2022-07-24 10:41
 * @Version : 1.0
 **/
public class Test07 {
    public char repeatedCharacter(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] sc = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = sc[i];
            if (map.containsKey(c)) {
                return c;
            } else {
                map.put(c, 1);
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        Test07 test = new Test07();
        System.out.println(test.repeatedCharacter("abcdd"));
    }
}
