package com.example.algorithm.string;

/**
 * @Description : 14. 最长公共前缀
 * @Author : young
 * @Date : 2022-08-10 9:48
 * @Version : 1.0
 **/
public class Test03 {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return strs[0];
        }
        int cnt = 0;
        String first = strs[0];
        boolean flag = true;
        while (flag) {
            for (int i = 1; i < len; i++) {
                if (cnt >= first.length() || cnt >= strs[i].length() || first.charAt(cnt) != strs[i].charAt(cnt)) {
                   flag = false;
                }
            }
            if (flag) {
                cnt++;
            }
        }

        return first.substring(0, cnt);
    }

    public static void main(String[] args) {
        Test03 test = new Test03();
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(test.longestCommonPrefix(strs));
    }
}
