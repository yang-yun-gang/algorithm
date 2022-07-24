package com.example.algorithm.tmp;

import java.util.Scanner;

/**
 * @Description : TODO
 * @Author : young
 * @Date : 2022-07-23 20:04
 * @Version : 1.0
 **/
public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int N = 2 * n;
        int[][] pos = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                pos[i][j] = scanner.nextInt();
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    //如果为直角三角
                    if (isTrip(pos[i], pos[j], pos[k])) {
                        res++;
                    }
                }
            }
        }

        System.out.print(res);

    }

    private static boolean isTrip(int[] a, int[] b, int[] c) {
        double x = Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2);
        double y = Math.pow(c[0] - a[0], 2) + Math.pow(c[1] - a[1], 2);
        double z = Math.pow(b[0] - c[0], 2) + Math.pow(b[1] - c[1], 2);

        if (x > y && x > z) {
            return x == y + z;
        } else if (y > x && y > z) {
            return y == x + z;
        } else {
            return z == x + y;
        }
    }
}
