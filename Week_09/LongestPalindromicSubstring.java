//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2736 👎 0

package leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("babad");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int begin, maxLength;
        public String longestPalindrome(String s) {
            // dp O(n^2) - O(n ^ 2)
            // 中心拓展O(n^2) - O(1)
            for (int i = 0; i < s.length(); i++) {
                extendPalindrome(s, i, i);
                extendPalindrome(s, i, i + 1);
            }
            return s.substring(begin, begin + maxLength);
            /*
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            String res = "";
            for (int i = 0; i < n; i++) {
                for (int j = i; j >= 0; j--) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) &&
                            (i - j < 2 || dp[i - 1][j + 1]);

                    if (dp[i][j] && i - j + 1 > res.length()) {
                        res = s.substring(j, i + 1);
                    }
                }
            }
            return res;
             */
        }

        private void extendPalindrome(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left --;
                right ++;
            }
            if (this.maxLength < right - left - 1) {
                this.begin = left + 1;
                this.maxLength = right - left - 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}