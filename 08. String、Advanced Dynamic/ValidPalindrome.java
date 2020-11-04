//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 256 👎 0

  
package leetcode.editor.cn;
public class ValidPalindrome{
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isPalindrome(String s) {
            // 题目要求: 在本题中 空字符串为有效的回文串
            // 直接正则去掉非字母和数字 然后反转
            /*
            String filterNonLetterAndDigit = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
            String newString = new StringBuilder(filterNonLetterAndDigit).reverse().toString();
            return filterNonLetterAndDigit.equals(newString);

             */
            if (s.equals("") || s.length() == 0) {
                return true;
            }
            // 双指针 左右指针 分别判断字母和数字的字符是否相等
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    left ++;
                }

                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    right --;
                }
                if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) {
                    return false;
                }
            }
            return true;
        }


//        public boolean isPalindrome(String s) {
            // 自顶向下编程
//          // 1. 先剔除字符串中所有非字母和数字的字符、返回剔除好的字符
            // 2. 翻转字符串
            // 3. 忽略大小写进行对比
//            String newStr = _filterNonNumberOrAlpha(s);
//            String reverseStr = _reverseString(newStr);
//            return newStr.equalsIgnoreCase(reverseStr);
//        }
//
//        private String _filterNonNumberOrAlpha(String s) {
//            return s.replaceAll("[^A-Za-z0-9]", "");
//        }
//
//        private String _reverseString(String s) {
//            return new StringBuilder(s).reverse().toString();
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}