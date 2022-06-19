package com.interview.prepare.xhs;

/**
 * 小红书 2022.3.13 笔试题
 *
 * 描述：
 * 给定一个数组，数组内元素只包含数字0或1，在这个数组内找到一个区间，将这个区间的数据0变成1、1变成0，即翻转区间区间内的01，
 * 请问翻转后可以使得数组中1的最多个数是多少
 *
 * 例如：1 1 0 0 1 0 0 1 1
 * 我们可以找到一个序列 [0 0 1 0 0] ,使得将它翻转后变为[1 1 0 1 1]，
 * 那么翻转后的数组为1 1 1 1 0 1 1 1 1，此时数组内1的个数为8，是1的个数最多的情况。
 */
public class ArrayRevertMaxSum {

    public static void main(String[] args) {
        int[] arr = {1,1,0,0,1,0,0,1,1};
        System.out.println(revert01MaxSum(arr));
    }

    public static int revert01MaxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int length = arr.length;

        // 0. 先求出数组中1的个数，简单累加即可
        int num = 0;
        for (int i = 0; i < length; i++) {
            num = num + arr[i];
        }

        // 1. 把数组的 0 变 1，1 变 -1
        // 比如  1  1  0  0  1  0  0  1  1
        // 变为 -1 -1  1  1 -1  1  1 -1 -1
        for (int i = 0; i < length; i++) {
            arr[i] = arr[i] == 0 ? 1 : -1;
        }

        // 2. 然后求连续子数组的最大累加和
        int max = arr[0];
        int pre = arr[0];
        for (int i = 1; i < length; i++) {
            // 可能性1是当前值，可能性2是当前值+上一个值，两者取最大；pre可以看作是当前位置、上一个位置的最大累加和
            pre = Math.max(pre + arr[i], arr[i]);
            // max，上一个位置max与当前位置最大累加和比较
            max = Math.max(max, pre);
        }

        return num + max;
    }
}
