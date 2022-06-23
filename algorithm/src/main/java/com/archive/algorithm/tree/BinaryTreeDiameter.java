package com.archive.algorithm.tree;

/**
 * 求二叉树直径（字节面试题）
 *
 * 描述：给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * 举例：
 *       1
 *      / \
 *     2   3
 *    / \
 *   4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 分析：https://www.bilibili.com/video/BV1ZS4y1c7dz/?spm_id_from=333.788
 */
public class BinaryTreeDiameter {

    /**
     * 二叉树直径
     */
    public static int DiameterOfBinaryTree(TreeNode node) {
        return process(node).maxDistance;
    }

    public static Info process(TreeNode node) {
        if (node == null) {
            return new Info(0, 0);
        }

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        // 高度
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        // 第一种可能性，不包含根节点，此时取左右两边最大路径的最大值 + 1
        int p1 = Math.max(leftInfo.maxDistance, rightInfo.maxDistance) + 1;
        // 第二种可能性，包含根节点，此时取左右两边高度合
        int p2 = leftInfo.height + rightInfo.height;
        // 最大路径取两种可能性中的最大值
        int maxDistance = Math.max(p1, p2);

        return new Info(maxDistance, height);
    }

    /**
     * 假设有这么一颗树
     */
    public static class TreeNode {
        private int value;
        public TreeNode left;
        public TreeNode right;
    }

    public static class Info {
        private int maxDistance;
        private int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }
}
