package com.example.algorithm.string;

/**
 * @Description : 43. 字符串相乘
 * @Author : young
 * @Date : 2022-08-11 9:20
 * @Version : 1.0
 **/
public class Test04 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        String res = "0";

        // 从右到左遍历num2
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            // 乘个位 十位 百位补零
            for (int k = n - 1; k > i; k--) {
                sb.append(0);
            }
            int add = 0;
            int a = num2.charAt(i) - '0';
            // num1乘num2的单位
            for (int j = m - 1; j >= 0; j--) {
                int b = num1.charAt(j) - '0';
                int t = a * b + add;
                sb.append(t % 10);
                add = t / 10;
            }
            if (add > 0) {
                sb.append(add);
            }
            // 字符串相加
            res = addString(res, sb.reverse().toString());
        }

        return res;
    }

    private String addString(String s1, String s2) {
        StringBuilder res = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int add = 0;
        // 巧
        while (i >=0 || j >= 0 || add != 0) {
            int a = (i >= 0) ? s1.charAt(i) - '0' : 0;
            int b = (j >= 0) ? s2.charAt(j) - '0' : 0;
            int t = a + b + add;
            res.append(t % 10);
            add = t / 10;
            i--;
            j--;
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Test04 test = new Test04();
        System.out.println(test.multiply("123", "456"));
    }
}
