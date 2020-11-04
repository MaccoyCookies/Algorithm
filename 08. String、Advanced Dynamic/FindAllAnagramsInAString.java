//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 379 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        solution.findAnagrams("cbaebabacd", "abc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            // 滑动窗口  O(n) - O(1)

            // init states
            List<Integer> res = new ArrayList<>();
            // 存放需要字母数量
            int[] needs = new int[26];
            // 计算需要的字母数量
            for (char c : p.toCharArray()) needs[c - 'a']++;
            // 初始化左右位置
            int left = 0, right = 0, count = p.length();
            // 当窗口右边达到边界结束
            while (right < s.length()) {
                // 如果进来的第一个字母刚好是需求里的 符合一个需求 count - 1
                if (needs[s.charAt(right++) - 'a']-- >= 1) count --;
                // 当count = 0时 当前窗口符合要求
                if (count == 0) res.add(left);
                // 当窗口长度已经到达边界 最左边的元素需要左移 如果左移的元素刚好是需求内的 那么count + 1
                // 也就是窗口还需要 count 个 才符合要求
                if (right - left == p.length() && needs[s.charAt(left++) - 'a']++ >= 0) count++;
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}