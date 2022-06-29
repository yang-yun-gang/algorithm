package com.example.algorithm.dp;

/**
 * @Description : 剑指 Offer 46. 把数字翻译成字符串
 * @Author : young
 * @Date : 2022-06-29 9:45
 * @Version : 1.0
 **/
public class Test05 {
    public int translateNum(int num) {

        String s = String.valueOf(num);

        int len = s.length();

        int a = 1, b = 1;
        for (int i = 1; i < len; i++) {
            // 与i-1组合大于25
            String substring = s.substring(i - 1, i + 1);
            int c = b;
            if (substring.compareTo("10") >= 0 && substring.compareTo("25") <= 0) {
                b += a;
            }
            a = c;
        }

        return b;
    }

    public static void main(String[] args) {
        Test05 test = new Test05();
        System.out.println(test.translateNum(18822));
    }
}
