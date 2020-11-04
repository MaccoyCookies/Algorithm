//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 315 👎 0


package leetcode.editor.cn;

import java.util.Stack;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        int min = Integer.MAX_VALUE;
        public int minDepth(TreeNode root) {
            // 1. 自上向下递归 O(n) - O(n)
            // 2. 自下往上递归 O(n) - O(n)
            // 3. 迭代
            if (root == null) {
                return 0;
            }
            int m1 = minDepth(root.left);
            int m2 = minDepth(root.right);
            // 最小深度必须是左右节点都为null的叶子节点
            // 当左右孩子有一方为空时 为空那方的深度为0 而且取不为空那方的深度 + 1
            // 当左右孩子都不会空时 取深度小的那一方 + 1
            return (root.left == null || root.right == null) ? m1 + m2 + 1 : Math.min(m1, m2) + 1;
            /*
            if (root == null) {
                return 0;
            }

            _helper(0, root);
            return min;
             */

        }
        private void _helper(int level, TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                min = Math.min(level + 1, min);
                return;
            }
            _helper(level + 1, root.left);
            _helper(level + 1, root.right);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}