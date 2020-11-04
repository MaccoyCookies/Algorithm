//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 266 👎 0

package leetcode.editor.cn;

public class ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
        solution.validPalindrome("abca");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int del = 0;  //记录删除的字符次数

        public boolean validPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left ++;
                    right--;
                } else {
                    //不相等的话，若没有删除字符，则删除左边或右边的字符再判断；若删除过一次，则不是回文串
                    if (del == 0) {
                        del++;
                        // 左闭右开
                        // 要么右边前进一位 要么左边前进一位
                        return validPalindrome(s.substring(left, right)) || validPalindrome(s.substring(left + 1, right + 1));
                    }
                    return false;
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}