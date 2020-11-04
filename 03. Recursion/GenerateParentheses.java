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
import java.util.List;

public class GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            _generate(0, 0, n, "");
            return ans;
            // 条件限制
            // 1. 记录左括号和右括号的数量
            // 1. 左括号小于n 才能加左括号
            // 2. 右括号小于等于左括号 才能加右括号
        }

        private void _generate(int left, int right, int n, String s) {
            // terminator
            if (s.length() == n * 2) {
                ans.add(s);
                return;
            }
            // process
            // drill down
            if (left < n) {
                _generate(left + 1, right, n, s + "(");
            }
            if (right < left) {
                _generate(left, right + 1, n, s + ")");
            }
            // reverse states

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}