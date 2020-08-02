//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组 
// 👍 639 👎 0

  
package leetcode.editor.cn;
public class RotateArray{
    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            // 1. 暴力破解 旋转n次 每次旋转1个元素 O(k * n) - 外层循环O(k), 内层移位循环O(n)
            // 2. 使用额外的数组 进行切片偏移 O(n) 但是题目不允许
            // 3. 环状 - 不太理解
            // 4. 反转数组 O(n) - n个元素被反转了3次

            // 如果k > nums.length, 那么k实际移动k%n次
            if (nums == null || nums.length < 2) {
                return;
            }

            k %= nums.length;
            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i];
                nums[i] = nums[(i + k) % nums.length];
                nums[(i + k) % nums.length] = temp;
            }
        }

        private void _reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start++] = nums[end];
                nums[end--] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}