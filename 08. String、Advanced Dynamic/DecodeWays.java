//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划 
// 👍 489 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class DecodeWays {
    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            // dp O(n) - O(n)
            // 分治 O(2^n) - O(n)
            int[] memo = new int[s.length()];
            Arrays.fill(memo, Integer.MIN_VALUE);
            return helper(s, memo, 0);
            /*
            int n = s.length();
            char[] charArray = s.toCharArray();
            if (charArray[0] == '0') return 0;
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                if (charArray[i] != '0') dp[i] = dp[i - 1];

                int num = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
                if (num >= 10 && num <= 26) {
                    dp[i] += i == 1 ? 1 : dp[i - 2];
                }
            }
            return dp[n - 1];
             */
        }

        private int helper(String s, int[] memo, int index) {
            // terminator
            if (s.length() == 0) return 1;
            if (memo[index] != Integer.MIN_VALUE) {
                return memo[index];
            }
            // process
            int cnt = 0;
            if (s.charAt(0) != '0') {
                cnt += helper(s.substring(1), memo, index + 1);
            }
            if (s.length() >= 2) {
                int num = 10 * (s.charAt(0) - '0') + (s.charAt(1) - '0');
                if (num >= 10 && num <= 26) {
                    cnt += helper(s.substring(2), memo, index + 2);
                }
            }
            // drill down
            memo[index] = cnt;
            return memo[index];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}