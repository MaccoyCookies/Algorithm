//班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 
//的朋友。所谓的朋友圈，是指所有朋友的集合。 
//
// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你
//必须输出所有学生中的已知的朋友圈总数。 
//
// 
//
// 示例 1： 
//
// 输入：
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//输出：2 
//解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。
//第2个学生自己在一个朋友圈。所以返回 2 。
// 
//
// 示例 2： 
//
// 输入：
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//输出：1
//解释：已知学生 0 和学生 1 互为朋友，学生 1 和学生 2 互为朋友，所以学生 0 和学生 2 也是朋友，所以他们三个在一个朋友圈，返回 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 200 
// M[i][i] == 1 
// M[i][j] == M[j][i] 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 313 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class FriendCircles {
    public static void main(String[] args) {
        Solution solution = new FriendCircles().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class UnionFind {
            private int count = 0;
            private int[] parent;

            public UnionFind(int n) {
                this.count = n;
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int find(int p) {
                int x = p;
                // 查找
                while (parent[p] != p) {
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }
                // 压缩
                while (x != p) {
                    int pre = parent[x];
                    parent[x] = p;
                    x = pre;
                }
                return p;
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) return;
                parent[rootP] = rootQ;
                count --;

            }
        }

        public int findCircleNum(int[][] M) {
            // DFS/BFS  O(n^2) - O(n)
            // 并查集  O(n * 1/2n * n) - O(n) 、矩阵只用访问一半、并查集时间复杂度最坏是O(n)

            // 初始化
            int n = M.length;
            UnionFind unionFind = new UnionFind(n);

            // 对朋友关系的添加到相同的集合里
            for (int i = 0; i < n; i++) {
                // 对称矩阵 - 只用遍历上半矩阵或者下半矩阵
                for (int j = i + 1; j < n; j++) {
                    if (M[i][j] == 1) {
                        unionFind.union(i, j);
                    }
                }
            }
            // 返回最后剩余集合
            return unionFind.getCount();

            /*BFS
            int n = M.length;
            int cnt = 0;
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    queue.offer(i);
                    while (!queue.isEmpty()) {
                        int cur = queue.poll();
                        visited[cur] = true;
                        for (int j = 0; j < n; j++) {
                            if (M[cur][j] == 1 && !visited[j]) {
                                queue.offer(j);
                            }
                        }
                    }
                    cnt ++;
                }
            }
            return cnt;
             */

            /* DFS
            int n = M.length;
            boolean[] visited = new boolean[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(M, visited, i);
                    count ++;
                }
            }
            return count;
             */
        }

        private void dfs(int[][] m, boolean[] visited, int i) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    dfs(m, visited, j);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}