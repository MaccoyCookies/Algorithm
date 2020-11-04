//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 225 👎 0

package leetcode.editor.cn;

public class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            // split Traverse-reverse generate
            if (s == null || s.length() == 0) return "";
            StringBuilder stringBuilder = new StringBuilder();
            String[] words = s.split(" ");
            for (String word : words) {
                stringBuilder.append(new StringBuilder(word).reverse().toString()).append(" ");
            }
            // return stringBuilder.toString().trim();
            return stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).toString();

            /*
            char[] charString = s.toCharArray();
            // Empty String
            if (charString.length == 0) return "";
            // process every word
            int start = 0;
            for (int i = 0; i < charString.length; i++) {
                if (charString[i] == ' ' || i == charString.length - 1) {
                    int left = start, right = i == charString.length - 1 ? i : i - 1;
                    while (left < right) {
                        char c = charString[left];
                        charString[left ++] = charString[right];
                        charString[right --] = c;
                    }
                    start = i + 1;
                }
            }
            return String.valueOf(charString);
             */
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}