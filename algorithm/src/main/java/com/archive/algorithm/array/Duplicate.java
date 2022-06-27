package com.archive.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字
 *
 * 描述：
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class Duplicate {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,2};
        System.out.println(findDuplicatedNumByHashSet(arr));
        System.out.println(findDuplicatedNumByArray(arr));
        // TODO：结果不对，但代码暂时没看出问题
        System.out.println(findDuplicatedNumDefault(arr));
    }

    /**
     * 借助哈希表
     * 前提是不要求空间复杂度
     */
    public static int findDuplicatedNumByHashSet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            // 存在则返回
            if (set.contains(num)) {
                return num;
            }
            // 不存在则存入
            set.add(num);
        }
        return -1;
    }

    /**
     * 借助数组
     * 前提是不要求空间复杂度
     */
    public static int findDuplicatedNumByArray(int[] arr) {
        // 定义一个数组，将 arr 的数字存放到 res 对应的索引上
        int[] res = new int[arr.length];
        for (int num : arr) {
            // 对应索引值等于1表示重复出现，返回该数字
            if (res[num] == 1) {
                return num;
            }
            // 对应索引值设为1
            res[num] = 1;
        }
        return -1;
    }

    /**
     * 在原数组上操作
     * 时间复杂度O(n)，空间复杂度O(1)
     * 思路：将数组上数字交换到对应的索引位置，如果该数字等于该数字对应索引的数字，说明数字重复
     */
    // int[] arr = {1,2,3,4,2};
    public static int findDuplicatedNumDefault(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 辅助变量，表示当前索引位置的值
            int num = arr[i];

            // 如果当前索引等于当前索引位置的值，即自己等于自己，不做操作
            if (i == num) {
                continue;
            }

            // 如果数字等于数字对应索引位置上的值，那么该数字就是重复的
            if (num == arr[num]) {
                return num;
            }

            // 交换数字与数字对应索引位置上的值，这一步是能够查询出结果的基础
            arr[i] = arr[num];
            arr[num] = num;
        }
        return -1;
    }

}
