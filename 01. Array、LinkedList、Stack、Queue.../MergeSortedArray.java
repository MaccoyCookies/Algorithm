//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针 
// 👍 575 👎 0

  
package leetcode.editor.cn;
public class MergeSortedArray{
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (nums1 == null || nums2 == null) {
                return;
            }
            // 1. 直接合并 然后排序 O((n + m)log(n + m))
            // 2. 双指针 从后往前 O(n + m)

            int numsLen1 = m - 1;
            int numsLen2 = n - 1;
            int len = m + n - 1;
            while (numsLen1 >= 0 && numsLen2 >= 0) {
                nums1[len--] = nums1[numsLen1] > nums2[numsLen2] ? nums1[numsLen1--] :  nums2[numsLen2--];
            }

            // 剩余2的元素全部小于1的元素, 直接覆盖到1的前几个就行了
            // System.arraycopy(nums2, 0, nums1, 0, numsLen2 + 1);
            // 如果说不能使用库函数
            while (numsLen2 >= 0) {
                nums1[len--] = nums2[numsLen2--];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}