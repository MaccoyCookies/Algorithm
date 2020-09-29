//给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。 
//
// 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是） 
//
// 题目数据保证答案符合 32 位带符号整数范围。 
//
// 
//
// 示例 1： 
//
// 输入：S = "rabbbit", T = "rabbit"
//输出：3
//解释：
//
//如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
// 
//
// 示例 2： 
//
// 输入：S = "babgbag", T = "bag"
//输出：5
//解释：
//
//如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。 
//(上箭头符号 ^ 表示选取的字母)
//
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^ 
// Related Topics 字符串 动态规划 
// 👍 258 👎 0

package leetcode.editor.cn;

public class DistinctSubsequences {
    public static void main(String[] args) {
        Solution solution = new DistinctSubsequences().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinct(String s, String t) {
            // dp O(n^2) - O(n^2)
            int m = s.length(), n = t.length();
            // Empty String
            if (m == 0) return 0;
            if (n == 0) return 1;
            // init states
            int[][] dp = new int[m + 1][n + 1];
            // if t.isEmpty  result -> 1
            for (int i = 0; i <= m; i++) dp[i][0] = 1;
            // process
            // dp state transition equation
            // s[i] == t[j] -> dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            // s[i] != t[j] -> dp[i][j] = dp[i - 1][j];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}