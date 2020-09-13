//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法 
// 👍 233 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new WordSearchIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Trie {
            Trie[] next = new Trie[26];
            String word;
            /** Initialize your data structure here. */
            public Trie() {

            }

            /** Inserts a word into the trie. */
            public void insert(String word) {
                Trie node = this;
                for (char c : word.toCharArray()) {
                    if (node.next[c - 'a'] == null) {
                        node.next[c - 'a'] = new Trie();
                    }
                    node = node.next[c - 'a'];
                }
                node.word = word;
            }
        }
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        public List<String> findWords(char[][] board, String[] words) {
            // 回溯(每次会4个方向四联通、每次延伸出去 需要考虑另外三个方向的时间复杂度、并且需要考虑单词长度L).
            // 字典树的时间复杂度O(n) + 循环遍历O(n^2) + 4^L次方 => O(n^2 * 4^L)
            List<String> res = new ArrayList<>();
            Trie root = new Trie();
            for (String word : words) {
                root.insert(word);
            }
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 如果当前字母是某个单词的开头 则进行4联通寻找
                    if (root.next[board[i][j] - 'a'] != null) {
                        dfs(board, i, j, root, res);
                    }
                }
            }
            return res;
        }

        private void dfs(char[][] board, int i, int j, Trie trie, List<String> res) {
            // terminator
            char c = board[i][j];
            Trie cur = trie.next[c - 'a'];
            if (cur == null) return;
            // process
            if (cur.word != null) {
                // 找到单词之后不能回退 因为有可能 "app、apps"
                // 也就是当找到一个单词之后 后面可能会有其他单词
                res.add(cur.word);
                // 去除重复
                cur.word = null;
            }
            board[i][j] = '#';
            // drill down
            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '#') {
                    continue;
                }
                dfs(board, x, y, cur, res);
            }
            // reverse states
            board[i][j] = c;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}