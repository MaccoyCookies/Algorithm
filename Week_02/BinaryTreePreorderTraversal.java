//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 330 👎 0

  
package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
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
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    class Solution {
        List<Integer> ans = new LinkedList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            // 1. 递归 - O(n) - O(n)
            // 2. 迭代 - O(n) - O(n)

            if (root != null) {
                ans.add(root.val);
                preorderTraversal(root.left);
                preorderTraversal(root.right);
            }
            return ans;

            /*
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> ans = new LinkedList<>();
            if (root == null) {
                return ans;
            }
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                ans.add(cur.val);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
            return ans;

             */
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}