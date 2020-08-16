//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 705 👎 0


package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            // 递归回溯 - O(n) - O(n)
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null) return res;
            dfs(res, nums, new ArrayList<Integer>(), 0);
            return res;

        }

        private void dfs(List<List<Integer>> res, int[] nums, List<Integer> list, int index) {
            // terminator
            if (index == nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }

            // process
            // drill down
            dfs(res, nums, list, index + 1);    // not pick the number of this index

            list.add(nums[index]);
            dfs(res, nums, list, index + 1);    // pick the number of this index

            // restore
            // 为了不影响之前的结果 如果直接传入 后面的层数会影响前面的结果
            // 因为在这里list已经不是局部变量了
            list.remove(list.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}