//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 417 👎 0

  
package leetcode.editor.cn;

import java.util.*;

public class GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            // 1. 排序 + map O(nlogn) - O(n)
            // 2. 质数计算 + map O(n) - O(n)
            Map<String, List<String>> hashmap = new HashMap<>();
            for (String str : strs) {
                char[] c = str.toCharArray();
                Arrays.sort(c);
                String sort_str = new String(c);
                List<String> list;
                if (hashmap.containsKey(sort_str)) {
                    list = hashmap.get(sort_str);
                } else {
                    list = new ArrayList<>();
                }
                list.add(str);
                hashmap.put(sort_str, list);
            }
            return new ArrayList<>(hashmap.values());


            /*
            int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

            Map<Integer, List<String>> hashmap = new HashMap<>();
            for (String str : strs) {
                int sum = 1;
                for (char c : str.toCharArray()) {
                    sum *= prime[c - 'a'];
                }
                List<String> list;
                if (hashmap.containsKey(sum)) {
                    list = hashmap.get(sum);
                } else {
                    list = new ArrayList<>();
                }
                list.add(str);
                hashmap.put(sum, list);
            }
            return new ArrayList<>(hashmap.values());

             */
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
}
