package com.example.algorithm.tmp;

import java.util.*;

/**
 * @Description : 美团8.20 考试得分
 * @Author : young
 * @Date : 2022-08-20 11:17
 * @Version : 1.0
 **/
public class Test07 {

    static class Que {
        int p;
        int a;
        public Que(int p, int a) {
            this.p = p;
            this.a = a;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ps = new int[n];
        for (int i = 0; i < n; i++) {
            ps[i] = sc.nextInt();
        }
        int[] as = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
        }


        List<Que> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Que que = new Que(ps[i], as[i]);
            list.add(que);
        }

        // 根据分值排序 倒序
        Collections.sort(list, new Comparator<Que>() {
            @Override
            public int compare(Que o1, Que o2) {
                int a = o1.a * 100 + o2.a * o2.p;
                int b = o1.a * o1.p + o2.a * 100;
                return b - a;
            }
        });

        double res = 0.0;
        for (Que que : list) {
            if (m > 0) {
                res += que.a;
                m--;
            } else {
                res += que.a * que.p * 0.01;
            }

        }

        System.out.println(String.format("%.2f", res));
    }


}
