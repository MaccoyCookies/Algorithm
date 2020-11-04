//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 524 👎 0

package leetcode.editor.cn;

public class SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new SudokuSolver().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        public void solveSudoku(char[][] board) {
            // 九宫格 每一行最多不过9种情况 (9!)^9 最坏情况下 从1试到9
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int n = board[i][j] - '0' - 1;
                        int box = (i / 3) * 3 + j / 3;
                        rows[i][n] = true;
                        cols[j][n] = true;
                        boxes[box][n] = true;
                    }
                }
            }
            dfs(board, 0, 0);
        }

        private boolean dfs(char[][] board, int i, int j) {
            // terminator
            if (j == 9) {
                j = 0;
                i += 1;
                if (i == 9) {
                    // 到了这里 证明已经进行到最后一个位置 前面所有位置的数字已经合法填充完毕
                    // 直接返回true即可
                    return true;
                }
            }
            // process
            int box = (i / 3) * 3 + j / 3;
            if (board[i][j] == '.') {
                for (int k = 0; k < 9; k++) {
                    // 判断是否合法
                    if (!(rows[i][k] || cols[j][k] || boxes[box][k])) {
                        rows[i][k] = true;
                        cols[j][k] = true;
                        boxes[box][k] = true;
                        board[i][j] = (char) (k + 1 + '0');
                        // 如果下层传递回来true  证明此层的数字k可以使用 不需要再进行回溯
                        if (dfs(board, i, j + 1)){
                            return true;
                        }
                        rows[i][k] = false;
                        cols[j][k] = false;
                        boxes[box][k] = false;
                        board[i][j] = '.';
                    }
                }
            } else {
                // 如果当前位置已经有值 直接进行下一层就好了
                return dfs(board, i, j + 1);
            }
            // 能到这个位置 说明当前层的9个数字都已经被使用完毕 需要进行回溯 退回上一层 所以返回false
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}