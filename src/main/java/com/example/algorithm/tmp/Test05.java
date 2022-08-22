package com.example.algorithm.tmp;

import java.util.Scanner;

/**
 * @Description : 美团8.20 交替打印
 * @Author : young
 * @Date : 2022-08-20 10:02
 * @Version : 1.0
 **/
public class Test05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s1 = sc.next();
        String s2 = sc.next();

        StringBuilder res = new StringBuilder();
        int i = 0, j = 0;
        boolean flag = false;
        while (i < n || j < n) {
            if (!flag) {
                res.append(s1.charAt(i));
                i++;
                flag = true;
            } else {
                res.append(s2.charAt(j));
                j++;
                flag = false;
            }
        }

        System.out.println(res.toString());
    }
}
