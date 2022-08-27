package com.java.guide.algorithm;

/**
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 10, 3, 0, 8, 4};
        // 需要一个有序数组
        Sort.bubbleSort(arr);
        // 二分查找 0 1 2 3 4 5 8 10
        int index = search(arr, 5);
        System.out.printf(String.valueOf(index));
    }

    public static int search(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        // 等于也要做循环, 或者说low与high相遇位也要查找是否是目标mum
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == num) {
                return mid;
            }
            if (arr[mid] >= num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
