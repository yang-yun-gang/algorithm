package com.example.algorithm.search;

/**
 * @Description : 力扣2305 公平分发饼干 https://leetcode.cn/problems/fair-distribution-of-cookies/
 * @Author : young
 * @Date : 2022-06-16 9:57
 * @Version : 1.0
 **/
public class Test01 {

    public int k;
    public int[] cookies;
    public int res = Integer.MAX_VALUE;
    public int n;

    public static void main(String[] args) {
        int[] cookies = new int[]{8,15,10,20,8};
        int k = 2;
        Test01 test01 = new Test01();
        System.out.println(test01.distributeCookies(cookies, k));
    }

    public int distributeCookies(int[] cookies, int k) {
        this.cookies = cookies;
        this.k = k;

        this.n = cookies.length;
        // 存放k个小朋友每个人当前的饼干数量
        int[] bucket = new int[k];

        // 从尾到前分发饼干
        distribute(bucket, n - 1);

        return res;
    }

    public void distribute(int[] bucket, int p) {

        // 饼干发完了
        if (p < 0) {
            int unfair = Integer.MIN_VALUE;
            for (int child : bucket) {
                unfair = (child > unfair) ? child : unfair;
            }
            res = (unfair < res) ? unfair : res;
            return;
        }

        // 剪枝1：如果剩余的饼干包不够空手的小朋友分了，直接返回，这种情况下肯定存在一个人空手，肯定不是最优解。
        int zeroCnt = 0;
        for (int child : bucket) {
            if (child == 0) zeroCnt++;
        }
        if (p + 1 < zeroCnt) return;

        // 剪枝2：如果过程中出现某位小朋友的饼干数量比当前的res还多，显然继续回溯下去也无法成为最优答案，直接返回。
        for (int child : bucket) {
            if (child >= res) return;
        }

        // 这块p饼干可以分发给k个人
        for (int i = 0; i < k; i++) {
            // 剪枝3：第一个零食包不管给哪个小朋友，所开启的回溯树都一样，只要给一个小朋友就行了
            if (p == n - 1 && i > 0) return;

            // 当前孩子饼干数增加
            bucket[i] += cookies[p];
            // 在此情况下，继续往下分发
            distribute(bucket, p - 1);
            bucket[i] -= cookies[p];
        }
    }
}
