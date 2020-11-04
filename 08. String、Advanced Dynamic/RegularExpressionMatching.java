//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// '.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
// Related Topics 字符串 动态规划 回溯算法 
// 👍 1581 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        solution.isMatch("aa", "a*");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            // 动态规划
            int m = s.length(), n = p.length();
            // Empty String
            if (n == 0 && m != 0) return false;
            // init states
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 2; i <= n; i++) dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 2];

            // dp state transition equation
            // s[i] == p[j] | '.' -> dp[i][j] = dp[i - 1][j - 1];
            // s[i] == '*'  -> dp[i][j] = dp[i][j - 2] || 前一个相等并且前面的字符都相同
            // s[i] != p[j] | '.' | '*' -> dp[i][j] = false
            for (int j = 1; j <= n; j++) {
                for (int i = 1; i <= m; i++) {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*'){
                        // '*' -> 0
                        // 与p前一个字符相同 或 p前一个字符为 '.' 并且
                        // s前一个字符在匹配当前 '*'时为true 当前s字符匹配*才可以生效
                        dp[i][j] = dp[i][j - 2] ||
                                ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') &&
                                        dp[i - 1][j]);
                    }
                }
            }
            return dp[m][n];
            /*
            // 最终 记忆化递归
            Map<int[], Boolean> memo = new HashMap<>();
            return memoMatch(s, p, memo);
             */

            /*
            // p -> regular
            if (p.length() == 0) return s.length() == 0;
            // deal with -> '.'
            boolean firstMatch = s.length() != 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
            // deal with -> '*'
            if (p.length() > 1 && p.charAt(1) == '*') {
                // '*' -> 0
                // '*' -> random
                // * 代表0位 0位直接略过当前情况
                // * 代表多位 多位表示下次还需要使用 所以保留 并且判断当前是否相等
                return isMatch(s, p.substring(2)) ||
                        (firstMatch && isMatch(s.substring(1), p));
            } else {
                return firstMatch && isMatch(s.substring(1), p.substring(1));
            }
             */
            /*
            // 二代匹配 处理'.'通配符
            if (s.length() == 0) return p.length() == 0;
            boolean firstMatch = p.length() != 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
            return firstMatch && isMatch(s.substring(1), p.substring(1));
             */
            /*
            // 初代匹配
            if (s.length() == 0) return p.length() == 0;
            boolean firstMatch = p.length() != 0 && s.charAt(0) == p.charAt(0);
            return firstMatch && isMatch(s.substring(1), p.substring(1));
             */
        }

        public boolean memoMatch(String s, String p, Map<int[], Boolean> memo) {
            // memo
            int m = s.length(), n = p.length();
            int[] cur = new int[]{m, n};
            boolean curIsMatch = false;
            if (memo.containsKey(cur)) {
                return memo.get(cur);
            }
            // terminator
            if (p.length() == 0) return s.length() == 0;
            // process
            boolean firstMatch = s.length() != 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
            if (p.length() >= 2 && p.charAt(1) == '*') {
                // 处理*通配符 两种情况
                // * 代表0位 0位直接略过当前情况
                // * 代表多位 多位表示下次还需要使用 所以保留 并且判断当前是否相等
                curIsMatch =  isMatch(s, p.substring(2)) ||
                        (firstMatch && isMatch(s.substring(1), p));
            } else {
                curIsMatch = firstMatch && isMatch(s.substring(1), p.substring(1));
            }
            memo.put(cur, curIsMatch);
            return curIsMatch;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}