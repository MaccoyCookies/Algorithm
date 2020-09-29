//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 225 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            // 1. 数组 只考虑小写字母 O(n) - O(1)
            // 2. Map结构 考虑unicode字符 O(n) - O(n)
            // 3. 排序 O(NlogN) - O(n)
            // 只有小写字母 可以使用大小为26的数组

            if (s.length() != t.length()) return false;
            char[] str1 = s.toCharArray();
            char[] str2 = t.toCharArray();
            Arrays.sort(str1);
            Arrays.sort(str2);
            return Arrays.equals(str1, str2);

            /*
            if (s.length() != t.length()) {
                return false;
            }
            int[] letter = new int[26];

            for (int i = 0; i < s.length(); i++) {
                letter[s.charAt(i) - 'a'] ++;
                letter[t.charAt(i) - 'a'] --;
            }
            for (int i : letter) {
                if (i < 0) {
                    return false;
                }
            }
            return true;
             */
            /*
            Map<Character, Integer> map = new HashMap<>();
    
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (char c : t.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) - 1);
            }

            for (Character c : map.keySet()) {
                if (map.get(c) != 0) {
                    return false;
                }
            }
            return true;
            */

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}