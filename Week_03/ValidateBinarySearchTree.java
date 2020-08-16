//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 704 👎 0

  
package leetcode.editor.cn;


import java.util.*;

public class ValidateBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
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
        long pre = Long.MIN_VALUE;
        public boolean isValidBST(TreeNode root) {
            // 递归 O(n) - O(n)
            // 迭代 O(n) - O(n) 需要用栈来维护
            if (root == null) return true;
            if (!isValidBST(root.left)) return false;
            if (root.val <= pre) return false;
            pre = root.val;
            return isValidBST(root.right);
            /*
            Stack<TreeNode> stack = new Stack<>();
            long pre = Long.MIN_VALUE;
            TreeNode cur = root;
            while (!stack.isEmpty() || cur != null) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                if (cur.val <= pre) return false;
                pre = cur.val;
                cur = cur.right;
            }
            return true;

             */
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}