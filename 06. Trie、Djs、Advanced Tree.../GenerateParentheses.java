//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1206 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Node {
            private String str;
            private int left;
            private int right;

            public Node(String str, int left, int right) {
                this.str = str;
                this.left = left;
                this.right = right;
            }
        }
        public List<String> generateParenthesis(int n) {
            // 1. BFS O(n) - O(n)
            // 2. DFS O(n) - O(n)
            // 条件限制
            // 1. 记录左括号和右括号的数量
            // 1. 左括号小于n 才能加左括号
            // 2. 右括号小于等于左括号 才能加右括号
            List<String> res = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            if (n == 0) return res;
            queue.offer(new Node("", 0, 0));
            while (!queue.isEmpty()) {
                Node curNode = queue.poll();
                if (curNode.left == n && curNode.right == n) {
                    res.add(curNode.str);
                    continue;
                }
                if (curNode.left < n) {
                    queue.offer(new Node(curNode.str + "(", curNode.left + 1, curNode.right));
                }
                if (curNode.right < curNode.left) {
                    queue.offer(new Node(curNode.str + ")", curNode.left, curNode.right + 1));
                }
            }
            return res;
            /*
            List<String> ans = new ArrayList<>();
            if (n == 0) return ans;
            _generate(0, 0, n, "", ans);
            return ans;
             */
        }

        private void _generate(int left, int right, int n, String s, List<String> ans) {
            // terminator
            if (s.length() == n * 2) {
                ans.add(s);
                return;
            }
            // process
            // drill down
            if (left < n) {
                _generate(left + 1, right, n, s + "(", ans);
            }
            if (right < left) {
                _generate(left, right + 1, n, s + ")", ans);
            }
            // reverse states

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}