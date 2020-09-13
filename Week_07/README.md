### Trie

1. 结点本身不存完整的单词
2. 从根节点到某一节点 路径上经过的字符连接起来 为该节点对应的字符串
3. 每个节点子节点路径代表的字符都不相同
4. <font color="red">实际上思想就是以空间换时间、利用字符串公共前缀减少查询时间的开销</font>

#### 基本结构

​	**大幅度减少无谓的比较** 并且每层只比较一个字符 查询效率极高

![image-20200913224548609](img/image-20200913224548609.png)

#### 应用

​	想要通过前缀找出所有联想的词语 只需要输出当成节点的所有子节点(可能性)即可

![image-20200913224509809](img/image-20200913224509809.png)

#### 内部实现

![image-20200913224911543](img/image-20200913224911543.png)

#### 扩展

​	节点本身不仅仅可以存储字符 还可以存储一些额外信息 例如频次

![image-20200913224849018](img/image-20200913224849018.png)

#### Java实现

```java
// 只有小写字母的Java代码模板
class Trie {
    Trie[] next;
    private final int R = 26;
    boolean isEnd = false;
    
    
    public void insert(String word) {
        Trie cur = this;
        for (char c : word.toCharArray()) {
            if (cur.next[c - 'a'] == null) {
				cur.next[c - 'a'] = new Trie();
            }
            cur = cur.next[c - 'a'];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie cur = this;
        for (char c : word.toCharArray()) {
            if (cur.next[c - 'a'] == null) return false;
            cur = cur.next[c - 'a'];
        }
		return cur.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Trie cur = this;
        for (char c : prefix.toCharArray()) {
            if (cur.next[c - 'a'] == null) return false;
            cur = cur.next[c - 'a'];
        }
		return true;
    }
}
```

### Disjoint Set / UnionFind

#### 应用

​	组团、配对问题、Group or not?

#### 基本操作

- makeSet(s)：建立一个新的并查集，其中包含 s 个单元素集合。 - 初始化
- unionSet(x, y)：把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在的集合不相交，如果相交则不合并。
- find(x)：找到元素 x 所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。

#### 看图学习

![image-20200913225713130](img/image-20200913225713130.png)

![image-20200913225727582](img/image-20200913225727582.png)

#### 优化

​	可以进行路径压缩(子节点直接指向父节点 时间复杂度压缩到O(1))

![image-20200913225816719](img/image-20200913225816719.png)

#### Java实现

```java
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
            // 小路径压缩 直接指向爷爷节点
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        // 路径压缩
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
```

### 高级搜索

1. 朴素搜索
2. 优化方式: 不重复(fifibonacci)- 不进行重复计算、剪枝(生成括号问题)-  根据条件 在搜索时去除不符合条件的延伸
3. 搜索方向： 
    1. DFS: depth fifirst search 深度优先搜索
    2. BFS: breadth fifirst search 广度优先搜索 
    3. 双向搜索、启发式搜索

#### Coin change 状态树

![image-20200913230127273](img/image-20200913230127273.png)

#### BFS/DFS Code

```java
// DFS代码模板
public void dfs(TreeNode root) {
    if (root == null) return;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode cur = stack.pop();
        // visited
        // process
        // generate result
        // sub stack push
    }
}

// BFS
public void bfs(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        TreeNode cur = queue.poll();
        // visited
        // process
        // generate result
        // sub queue.push
    }
}
```

#### 剪枝

​	在当层中, 根据条件 **将不符合条件的延伸去除** 以免进行不必要的计算

#### 双向BFS

![image-20200913230738893](img/image-20200913230738893.png)

![image-20200913230800241](img/image-20200913230800241.png)

![image-20200913230820362](img/image-20200913230820362.png)

#### 启发式搜索(A*)

​	在普通搜索(BFS)的基础上 增加优先级计算 而不是普通原本的傻搜、也就是估价函数

##### 估价函数

启发式函数： h(n)，它用来**评价哪些结点最有希望的是一个我们要找的结点**，h(n) 会返回一个非负实数,也可以认为是从结点n的目标结点路径的估计成本。

启发式函数是一种**告知搜索方向**的方法。它提供了一种明智的方法来猜测**哪个邻居结点会导向一个目标**。







