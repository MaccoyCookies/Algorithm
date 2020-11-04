//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 614 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            // 排序(NlogN) 最后遍历 O(n)
            // 空间存放答案数量 最坏时间复杂度为O(n) n -> intervals.length 平均为logN
            // 对每个数组的第一位进行排序
            // 再遍历一遍
            if (intervals.length == 0) return new int[0][2];
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            List<int[]> merge = new ArrayList<>();
            for (int[] interval : intervals) {
                int L = interval[0], R = interval[1];
                if (merge.size() == 0 || merge.get(merge.size() - 1)[1] < L) {
                    merge.add(new int[]{L, R});
                } else {
                    merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], R);
                }
            }
            return merge.toArray(new int[merge.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}