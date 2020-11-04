//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N
//-1 步，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 141 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueensIi{
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int count = 0;
        int size = 0;
        public int totalNQueens(int n) {
            // 普通DFS 数组判重
            // 位运算 判重
            // 时间复杂度都是 O(N!)
            // 空间复杂度由于位运算使用的是数字 所以为O(1)、但是递归的系统栈 最多不过N层 所以还是O(N)
            if (n == 0) return 0;
            // 得到全n位全1的二进制数 如果最后条件=size, 则表示已经满足要求
            this.size = (1 << n) - 1;
            dfs(0, 0, 0);
            return count;
        }

        private void dfs(int cols, int pie, int na) {
            // terminator
            if (cols == size) {
                count ++;
                return;
            }
            // process
            // ~(cols | pie | na) 得到所有被打掉的格子 对应位置赋为1, 由于二进制是32位 所有n前面也会被赋为1
            // (1 << n) - 1 得到除了高位是0、低位全是1的n进制数
            // 最后两者结合 与运算
            int pos = size & (~(cols | pie | na));
            while (pos != 0) {
                // drill down
                // 得到最低位1的位置
                int p = pos & -pos;
                // 从当前填充皇后的位置 也可以使用 pos -= p;
                pos = pos & (pos - 1);
                dfs(cols | p, (pie | p) << 1, (na | p) >> 1);
            }
            // reverse states
        }
//        boolean[] rows;
//        boolean[] pie;
//        boolean[] na;
//        int count = 0;
//        public int totalNQueens(int n) {
//            // O(n!)
//            if (n == 0) return 0;
//            this.rows = new boolean[n];
//            this.pie = new boolean[2 * n - 1];
//            this.na = new boolean[2 * n - 1];
//            dfs(n, 0);
//            return count;
//        }
//
//        private void dfs(int n, int row) {
//            // terminator
//            if (row == n) {
//                count ++;
//                return;
//            }
//            // process current logic
//            for (int i = 0; i < n; i++) {
//                if (rows[i] || pie[row + i] || na[row - i + n - 1]) {
//                    continue;
//                }
//                // drill down
//                rows[i] = true;
//                pie[row + i] = true;
//                na[row - i + n - 1] = true;
//                dfs(n, row + 1);
//                // restore current states
//                rows[i] = false;
//                pie[row + i] = false;
//                na[row - i + n - 1] = false;
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}