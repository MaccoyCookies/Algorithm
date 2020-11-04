//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1160 👎 0

  
package leetcode.editor.cn;
public class ClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            // 1. 迭代 - O(n) - O(1)
            // 2. 递归 - O(2^n)
            // 3. 缓存递归 - O(n) - O(n)
            /*
            if (n <= 2) {
                return n;
            }
            int first = 1;
            int second = 2;
            for (int i = 3; i <= n; i++) {
                int third = first + second;
                first = second;
                second = third;
            }
            return second;
             */
            int[] memo = new int[n + 1];
            return _climbStairsMemo(n, memo);
        }

        private int _climbStairsMemo(int n, int[] memo) {
            // terminator
            if (memo[n] > 0) {
                return memo[n];
            }
            if (n <= 3) {
                memo[n] = n;
                return memo[n];
            }
            // process
            // drill down
            memo[n] = _climbStairsMemo(n - 1, memo) + _climbStairsMemo(n - 2, memo);
            return memo[n];
            // restore
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}