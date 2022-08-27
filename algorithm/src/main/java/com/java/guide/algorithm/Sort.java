package com.java.guide.algorithm;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 排序算法
 */
public class Sort {

    public static void main(String[] args) {
        // case 1： bubble sort
        int[] arr1 = {5, 2, 1, 10, 3, 0, 8, 4};
        bubbleSort(arr1);
        Arrays.stream(arr1).forEach(num -> System.out.print(num+" "));

        System.out.println();

        // case 2: quick sort
        int[] arr2 = {5, 2, 1, 10, 3, 0, 8, 4};
        quickSort(arr2,0,7);
        Arrays.stream(arr2).forEach(num -> System.out.print(num+" "));
    }

    /**
     * 快速排序
     * 将数组中小于基准数的数据移到基准数左边，大于基准数的移到右边，不断重复直到全部有序；假设左右各有一个哨兵
     * low,high 为每次处理数组时的首、尾元素索引
     * 参考 https://blog.csdn.net/wthfeng/article/details/78037228
     */
    public static void quickSort(int[] arr, int low, int high) {
        // 当low==high是表示该序列只有一个元素，不必排序了
        if (low >= high) {
            return;
        }

        // 选出哨兵元素和基准元素。这里左边的哨兵元素也是基准元素
        int base = arr[low];
        int i = low, j = high;
        while (i < j) {
            while (arr[j] >= base && i < j) { //右边哨兵从后向前找
                j--;
            }
            while (arr[i] <= base && i < j) { //左边哨兵从前向后找
                i++;
            }
            swap(arr, i, j);  //右边比基准小的、左边比基准大的时候交换元素
        }

        //基准元素与右哨兵交换
        swap(arr, low, j);

        //递归调用，排序左子集合和右子集合
        quickSort(arr, low,j-1);
        quickSort(arr,j+1, high);
    }

    /**
     * 冒泡排序
     * 每次拿标准位与后面所有元素比较，满足大于或小于条件就交换，大于交换为升序否则为倒序
     */
    public static void bubbleSort(int[] arr) {
        //外层i控制循环次数, i与i后所有位进行比较 满足条件进行交换
        for (int i = 0; i < arr.length; i++) {
            // j始终从i后一位开始
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
