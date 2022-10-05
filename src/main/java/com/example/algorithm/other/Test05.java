package com.example.algorithm.other;

/**
 * @Description : 5. 最长回文子串
 * @Author : young
 * @Date : 2022-10-04 11:10
 * @Version : 1.0
 **/
public class Test05 {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 奇数中心
            String s1 = recur(s, i, i);
            // 偶数中心
            String s2 = recur(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }

        return res;
    }

    // 求以l, r为中心的最长回文串
    private String recur(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        Test05 test = new Test05();
        System.out.println(test.longestPalindrome("babad"));
    }
}
