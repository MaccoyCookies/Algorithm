//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 507 👎 0


package leetcode.editor.cn;

import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            // 位运算
            List<List<String>> res = new ArrayList<>();
            if (n == 0) return res;
            char[][] board = new char[n][n];
            for (char[] chars : board) {
                Arrays.fill(chars, '.');
            }
            dfs(n, 0, 0, 0, board, res);
            return res;
        }

        private void dfs(int n, int cols, int pie, int na, char[][] board, List<List<String>> res) {
            // terminator
            int size = (1 << n) - 1;
            if (cols == size) {
                res.add(generateResult(board));
                return;
            }
            // process
            int pos = size & (~(cols | pie | na));
            while (pos != 0) {
                // drill down
                int p = pos & -pos;
                pos = pos & (pos - 1);
                // 得到当前层数、使用的列数
                int col = Integer.bitCount(p - 1);
                int row = Integer.bitCount(cols);
                board[row][col] = 'Q';
                dfs(n, cols | p, (pie | p) << 1, (na | p) >> 1, board, res);
                // reverse states
                board[row][col] = '.';
            }

        }

        private List<String> generateResult(char[][] board) {
            List<String> temp = new ArrayList<>();
            for (char[] chars : board) {
                temp.add(String.valueOf(chars));
            }
            return temp;
        }
//        boolean[] rows;
//        boolean[] pie;
//        boolean[] na;
//        List<List<String>> res = new ArrayList<>();
//
//        public List<List<String>> solveNQueens(int n) {
//            // O(n!) - O(n)
//            if (n == 0) return res;
//
//            this.rows = new boolean[n];
//            this.pie = new boolean[2 * n - 1];
//            this.na = new boolean[2 * n - 1];
//
//            char[][] board = new char[n][n];
//            for (char[] chars : board) {
//                Arrays.fill(chars, '.');
//            }
//
//            dfs(n, 0, board);
//            return res;
//        }
//
//        private void dfs(int n, int row, char[][] board) {
//            // terminator
//            if (row == n) {
//                res.add(_generate_result(board));
//                return;
//            }
//
//            // process current logic
//            for (int i = 0; i < n; i++) {
//                if (rows[i] || pie[row + i] || na[row - i + n - 1]) {
//                    continue;
//                }
//                // drill down
//                rows[i] = true;
//                pie[row + i] = true;
//                na[row - i + n - 1] = true;
//
//                board[row][i] = 'Q';
//                dfs(n, row + 1, board);
//
//                // restore current states
//                board[row][i] = '.';
//                rows[i] = false;
//                pie[row + i] = false;
//                na[row - i + n - 1] = false;
//            }
//        }
//
//        private List<String> _generate_result(char[][] board) {
//            List<String> val = new LinkedList<>();
//            for (char[] chars : board) {
//                val.add(new String(chars));
//            }
//            return val;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}