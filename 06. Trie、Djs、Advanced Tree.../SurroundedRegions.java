//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 365 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();
        char[][] board = new char[][]{
                {'O','X','X','O','X'},
                {'X','X','X','X','O'},
                {'X','X','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'},
        };
        solution.solve(board);

        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] direction = new int[][]{
                {0, -1}, // 左
                {-1, 0}, // 上
                {0, 1}, // 右
                {1, 0} // 下
        };
        int row, col;
        public void solve(char[][] board) {
            // dfs O(n^2) - O(n^2)
            if (board.length == 0 || board[0].length == 0) return;
            row = board.length;
            col = board[0].length;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    // 边缘开始搜索
                    if ((i == 0 || i == row - 1 || j == 0 || j == col - 1) && board[i][j] == 'O') {
                        dfs(i, j, board);
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') board[i][j] = 'X';
                    if (board[i][j] == '#') board[i][j] = 'O';
                }
            }


        }

        private void dfs(int i, int j, char[][] board) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
                return;
            }
            board[i][j] = '#';
            for (int[] ints : direction) {
                int x = i + ints[0];
                int y = j + ints[1];
                dfs(x, y, board);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}