//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 132 👎 0

package leetcode.editor.cn;

public class ReversePairs {
    public static void main(String[] args) {
        Solution solution = new ReversePairs().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int count = 0;
        public int reversePairs(int[] nums) {
            // 其实 就像是逆序对一样 符合条件就是前面的数字比后面的大 只不过这里是必须大两倍
            // 所以我们这里可以使用归并排序
            // 因为归并排序的话 - 划分左右数组 最后进行合并 在合并的时候 需要判断左右大小 这个时候就可以进行统计
            // 归并排序 O(NlogN) 只是在合并的时候 添加一步判断的操作 不影响总体的时间复杂度
            int n = nums.length;
            return mergeSort(nums, 0, n - 1);
        }

        private int mergeSort(int[] nums, int left, int right) {
            // terminator
            if (right <= left) return 0;
            // 划分左右数组 数组长度不超过5w 不用担心越界 - ((right - left) >> 1) + left
            int mid = (left + right) >> 1;
            int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
            int[] temp = new int[right - left + 1];
            // i、j、c用于合并数组 t用于在合并的时候进行统计符合条件个数
            int i = left, t = left, j = mid + 1, c = 0;
            // 这里和普通归并排序不同的是 每次j只走一步 因为每个j都需要判断有多少个t能够大于两倍
            // 而为什么t不需要每次只走一步 是因为如果当前数符合条件 那么按照升序的原理 后面的数字肯定也符合条件
            for (; j <= right; j++) {
                // 统计符合条件 找到第一个符合条件i的位置 那么i - mid 之间的数字 肯定都符合当前对j的条件
                while (t <= mid && nums[t] / 2.0 <= nums[j]) t++;
                // 正常进行合并 这里跟普通的合并不太一样
                // 这里是将小于j的数字先放进去 然后出循环之后 当前i > j
                while (i <= mid && nums[i] <= nums[j]) temp[c++] = nums[i++];
                // 所以当前j找到了应该存放的位置
                temp[c++] = nums[j];
                count += mid - t + 1;
            }
            // 上面循环是为了能够查询所有的j 所以这里有可能i还没有合并完
            // 剩余的i肯定是大于j的 直接存放即可
            while (i <= mid) temp[c++] = nums[i++];
            System.arraycopy(temp, 0, nums, left, temp.length);
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}