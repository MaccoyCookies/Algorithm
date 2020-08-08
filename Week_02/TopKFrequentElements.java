//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 418 👎 0

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements{
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            // 1. HashMap + 优先队列 - O(Nlogk) - O(N)
            if (nums == null || nums.length == 0 || k == 0) {
                return new int[0];
            }
            Map<Integer, Integer> map = new HashMap<>();
            Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> map.get(v1) - map.get(v2));
            int[] ans = new int[k];
            // 统计次数 - O(N)
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            // 只存前k位 - O(Nlogk)
            for (int num : map.keySet()) {
                queue.offer(num);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            // O(n)
            for (int i = 0; i < k; i++) {
                ans[i] = queue.poll();
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}