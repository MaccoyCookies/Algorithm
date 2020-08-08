//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索 
// 👍 100 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NAryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
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
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> levelOrder(Node root) {
            // 递归 O(n) - O(n)
            if (root == null) {
                return ans;
            }
            _helper(root, 0);
            return ans;
        }

        private void _helper(Node root, int level) {
            if (level >= ans.size()) {
                ans.add(new ArrayList<>());
            }
            ans.get(level).add(root.val);
            for (Node child : root.children) {
                _helper(child, level + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}