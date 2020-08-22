//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 723 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            // DFS O(M*N) - O(M*N)
            // BFS O(M*N) - O(M*N)
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int n = grid.length;
            int m = grid[0].length;
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1') {
                        grid[i][j] = '0';
                        count ++;
                        Queue<Integer> queue = new LinkedList<>();
                        // 这里相当于一个小型数学公式 前提是 i 和 j < m 并且是整数
                        queue.offer(i * m + j);
                        while (!queue.isEmpty()) {
                            int curLocaltion = queue.poll();
                            int x = curLocaltion / m;
                            int y = curLocaltion % m;
                            if (x - 1 >= 0   && grid[x - 1][y] == '1') {
                                queue.offer((x - 1) * m + y);
                                grid[x - 1][y] = '0';
                            }
                            if (x + 1 < n && grid[x + 1][y] == '1') {
                                queue.offer((x + 1) * m + y);
                                grid[x + 1][y] = '0';
                            }
                            if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                                queue.offer(x * m + y - 1);
                                grid[x][y - 1] = '0';
                            }
                            if (y + 1 < m && grid[x][y + 1] == '1') {
                                queue.offer(x * m + y + 1);
                                grid[x][y + 1] = '0';
                            }
                        }
                    }
                }
            }
            return count;
                
            /*
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int n = grid.length;
            int m = grid[0].length;
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        count ++;
                    }
                }
            }
            return count;
             */
        }

        private void dfs(char[][] grid, int i, int j) {
            // terminator
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return;

            // process
            grid[i][j] = '0';

            // drill down
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
            // restore states
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}