package com.java.guide.algorithm;

/**
 * 动态规划
 * 一种使用前面结果逐步递推求出最终结果、解决复杂问题的方法
 */
public class DynamicProgramming {

    public static void main(String[] args) {
        // case 1: minPathSum
        int[][] grid = {{1,3,5,9},
                        {8,1,3,4},
                        {5,0,6,1},
                        {8,8,4,0}};
        System.out.println(minPathSum(grid));

        // case 2: maxRangeSum
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        System.out.println(maxRangeSum(arr));
    }

    /**
     * 子数组最大累加和问题
     *
     * 描述：输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，
     * 子数组最小长度为1。求所有子数组的和的最大值。
     * 例如：[1,-2,3,10,-4,7,2,-5]
     * 经分析可知，输入数组的子数组[3,10,-4,7,2]可以求得最大和为18
     *
     * 分析：https://www.bilibili.com/video/av853500001
     * 参考：https://blog.csdn.net/qq_43638033/article/details/116028931
     */
    public static int maxRangeSum(int[] arr) {
        // check
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int size = arr.length;

        // 定义dynamic数组并初始化第一个位置的值
        int[] dp = new int[size];
        dp[0] = arr[0];

        // 最大和变量
        int max = dp[0];

        for (int i = 1; i < size; i++) {
            // i 位置上的最大累加和 等于 上一个位置的最大累加和+当前位置 与 当前位置 中的最大值
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            // 更新max
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /**
     * 矩阵最小路径和问题
     *
     * 描述：给定一个矩阵grid，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，
     * 路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
     * 例如：
     * 1 3 5 9
     * 8 1 3 4
     * 5 0 6 1
     * 8 8 4 0
     * 路径 1, 3, 1, 0, 6, 1, 0 是所有路径中路径和最小的，所以返回12。
     *
     * 分析：https://blog.csdn.net/qq_27703417/article/details/70981769
     */
    public static int minPathSum(int[][] grid) {
        // check
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // 数组的行与列
        int m = grid.length;
        int n = grid[0].length;

        // dynamic结果数组，且可以初始化[0][0]位置上的值
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // 先计算第一行每个位置的路径和, 只能是水平左侧的结果+该位置上的值
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        // 先计算第一列每个位置的路径和, 只能是垂直上面的结果+该位置上的值
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j-1][0] + grid[j][0];
        }

        // 遍历每个位置，选择用左和上的最小结果值 + 当前位置
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        // 右下角的结果值就是最终结果
        return dp[m-1][n-1];
    }
}
