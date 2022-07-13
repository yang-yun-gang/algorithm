package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * @Description : 快速排序
 * @Author : young
 * @Date : 2022-07-13 9:30
 * @Version : 1.0
 **/
public class QuickSort {
    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    // 递归
    private static void quickSort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int pivot = partition(nums, i, j);
        quickSort(nums, i, pivot - 1);
        quickSort(nums, pivot + 1, j);
    }

    // 划分操作
    private static int partition(int[] nums, int i, int j) {

        int pivot = i;
        // 所有小于中分值的数移到左边，大于中分值的数移到右边 先移动j
        while (i < j) {
            // 从右到左 找到第一个小于中分值的数
            while (i < j && nums[j] >= nums[pivot]) j--;
            // 从左到右 找到第一个大于中分值的数
            while (i < j && nums[i] <= nums[pivot]) i++;

            // 交换
            swap(nums, i, j);
        }

        // 中分值到它的最终位
        swap(nums, pivot, i);

        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 2, 5};
        QuickSort.sort(nums);
        Arrays.stream(nums).forEach((i)-> System.out.print(i + ","));
    }
}
