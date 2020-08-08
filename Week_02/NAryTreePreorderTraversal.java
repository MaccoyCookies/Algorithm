//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 91 👎 0

  
package leetcode.editor.cn;

import java.util.*;

public class NAryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreePreorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

    class Solution {
        List<Integer> ans = new ArrayList<>();
        public List<Integer> preorder(Node root) {
            // 1. 递归 O(n) - O(n)
            // 2. 迭代 O(n) - O(n)
            if (root == null) {
                return ans;
            }
            ans.add(root.val);
            for (Node child : root.children) {
                preorder(child);
            }
            return ans;

            /*
            LinkedList<Node> stack = new LinkedList<>();
            LinkedList<Integer> ans = new LinkedList<>();
            if (root == null) {
                return ans;
            }
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pollLast();
                ans.add(node.val);
                Collections.reverse(node.children);
                for (Node child : node.children) {
                    stack.addLast(child);
                }
            }
            return ans;
            */
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}