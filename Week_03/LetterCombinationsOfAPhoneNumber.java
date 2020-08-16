//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 829 👎 0


package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, String> letterMap = new HashMap<>();
        {
            letterMap.put(2, "abc");
            letterMap.put(3, "def");
            letterMap.put(4, "ghi");
            letterMap.put(5, "jkl");
            letterMap.put(6, "mno");
            letterMap.put(7, "pqrs");
            letterMap.put(8, "tuv");
            letterMap.put(9, "wxyz");
        }
        List<String> res = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            // 递归 O(3^n * 4^m)
            // 其中 N 是输入数字中对应 3 个字母的数目（比方说 2，3，4，5，6，8），
            // M 是输入数字中对应 4 个字母的数目（比方说 7，9），N+M 是输入数字的总数。
            if (digits.isEmpty()) return res;
            combinations(digits, "");
            return res;
        }

        private void combinations(String digits, String str) {
            // terminator
            if (str.length() == digits.length()) {
                res.add(str);
                return;
            }
            // process current logic
            // drill down
            String letters = letterMap.get(digits.charAt(str.length()) - '0');
            for (char c : letters.toCharArray()) {
                combinations(digits, str + c);
            }

            // restore current status
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}