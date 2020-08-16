//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 702 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            // map计数 遍历 O(n) - O(n)
            // 排序法 O(NlogN) - O(1)
            // 摩尔斯投票法 O(n) - O(1)
            /*
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (map.get(num) >= Math.ceil(nums.length / 2.0)) {
                    return num;
                }
            }
            return -1;
             */
            /*
            Arrays.sort(nums);
            return nums[nums.length / 2];
             */

            int cand_num = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (cand_num == nums[i]) {
                    count ++;
                } else if (--count == 0) {
                    cand_num = nums[i];
                    count = 1;
                }
            }
            return cand_num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}