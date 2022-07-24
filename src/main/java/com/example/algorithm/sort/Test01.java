package com.example.algorithm.sort;

/**
 * @Description : 剑指 Offer 40. 最小的 k 个数
 * @Author : young
 * @Date : 2022-07-14 8:28
 * @Version : 1.0
 **/
public class Test01 {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 冒泡排序
        for (int i = 0; i < k; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }

        return res;
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 1};
        Test01 test = new Test01();
        System.out.println(test.getLeastNumbers(arr, 1));
    }
}
