package com.example.algorithm.dp;

/**
 * @Description : 力扣6100. 统计放置房子的方式数
 * @Author : young
 * @Date : 2022-06-27 11:15
 * @Version : 1.0
 **/
public class Test02 {
    public int countHousePlacements(int n) {

        long res = f(n);

        return (int) (res * res % 1000000007); // 这里两个Int乘会越界
    }

    private long f(int n) {
        if (n == 1) return 2;
        if (n == 2) return 3;

        int a = 2;
        int b = 3;
        int k = 3;
        while (k++ <= n) {
            int tmp = b;
            b = (b + a) % (1000000007);
            a = tmp;
        }

        return b;
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        System.out.println(test02.countHousePlacements(1000));
    }
}
