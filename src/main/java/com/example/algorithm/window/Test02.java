package com.example.algorithm.window;

import java.util.*;

/**
 * @Description : 剑指 Offer 59 - I. 滑动窗口的最大值
 * @Author : young
 * @Date : 2022-07-26 8:51
 * @Version : 1.0
 **/
public class Test02 {
    // 暴力+剪枝
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int l = 0, r = k - 1;
        List<Integer> list = new ArrayList<>();

        // 找出第一个窗口最大值位置
        int p = findMax(nums, 0, k - 1);
        list.add(nums[p]);

        while (r + 1 < nums.length) {
            l++;
            r++;
            if (p >= l) {
                if (nums[r] > nums[p]) {
                    p = r;
                }
            } else {
                // 滑出了窗口
                p = findMax(nums, l, r);
            }
            list.add(nums[p]);
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    private int findMax(int[] nums, int l, int r) {
        int p = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > nums[p]) {
                p = i;
            }
        }
        return p;
    }

    // 单调队列
    public int[] maxSlidingWindow2(int[] nums, int k) {

        if (nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        // 未形成窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }

        res[0] = deque.peekFirst();
        // 形成窗口
        for (int i = k; i < nums.length; i++) {
            // 判断最大值出界
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);

            res[i - k + 1] = deque.peekFirst();
        }

        return res;
    }

    public static void main(String[] args) {
        Test02 test = new Test02();
        int[] res = test.maxSlidingWindow2(new int[]{1, -1}, 1);
        Arrays.stream(res).forEach((i)-> System.out.print(i + " "));
    }
}
