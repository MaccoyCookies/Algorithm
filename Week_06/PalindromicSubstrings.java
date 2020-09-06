//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 331 👎 0


package leetcode.editor.cn;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            // 1. 中心拓展 O(n^2) - O(1)
            /*
            int n = s.length();
            int count = 0;
            for (int i = 0; i < 2 * n - 1; i++) {
                // s = "abc"
                // 0 1 2 3 4 5
                int left = i / 2; // 0 0. 1 1. 2 2. 3
                int right = i / 2 + i % 2; // 0 1. 1 2. 2 3. 3.
                while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                    left --;
                    right ++;
                    count ++;
                }
            }
            return count;
             */
            // 2. 动态dp O(n^2) - O(n^2)
            int n = s.length();
            int count = 0;
            // 存放之间小字符串的结果
            boolean[][] dp = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    // i - j 小于2的话 代表要么是同一个字符 要么是相邻的两个字符
                    if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i-1][j+1])) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}