package com.example.algorithm.tmp;

import java.util.Scanner;

/**
 * @Description : TODO
 * @Author : young
 * @Date : 2022-07-23 19:40
 * @Version : 1.0
 **/
public class Test01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            System.out.print(addWindow(nums[i], i, N) + " ");
        }

    }

    private static long addWindow(double num, int n, int N) {
        double res = num * 0.5 * (1 - Math.cos(2 * 3.1415927 * n / N));
        if (res >= 0) {
            return (long) (res + 0.5);
        } else {
            return (long) (res - 0.5);
        }

    }
}
