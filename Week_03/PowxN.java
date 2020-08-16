//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找 
// 👍 467 👎 0


package leetcode.editor.cn;

public class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            // 1. 暴力 O(n) - O(1) - 超出时间限制
            // 2. 迭代 O(logN) - O(1)
            // 3. 分治 O(logN) - O(logN)
            if (n == 0) {
                return 1;
            }
            return n > 0 ? quickMul(x, n) : 1.0 / quickMul(x, n);
            /*
            // 如果n小于0  则求|n|结果倒数即可 但是如果是 -2^32 无法进行-n 所以这里只能在结果进行倒数
            // if (n < 0) return 1.0 / myPow(x, -n);
            double res = 1.0;
            for (int i = n; i != 0; i /= 2) {
                if (i % 2 != 0) {
                    res *= x;
                }
                x *= x;
            }
            return n < 0 ? 1.0 / res : res;
             */

        }

        private double quickMul(double x, int n) {
            // terminator
            if (n == 0 || x == 1) {
                return 1;
            }
            // process current logic
            double temp = quickMul(x, n / 2);
            // drill down
            // merge
            return n % 2 == 0 ? temp * temp : temp * temp * x;
            // restore cuurent status
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}