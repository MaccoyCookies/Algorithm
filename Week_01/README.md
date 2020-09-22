学习使我快乐!

#### *API查阅*

​	Google 搜索 "api language version" - "stack java 8"

#### 源码下载

​	Google 搜索 "source api java" - "source stack java"

#### 算法优化

​	空间换时间

#### 如何精通一个领域

##### Chunk it up - 切碎知识点

​	将一个大知识点, 转换成许多小知识点(脉络链接, 转换成tree一样的结构知识点)

***数据结构***

> - 一维
>     - 基础: 数组(Arrays)、链表(Linked List)
>     - 高级: 栈(Stack)、队列(Queue)、双端队列(Deque)、集合(Set)、映射(Map [hash or map])、etc
> - 二维
>     - 基础: 树(tree)、图(graph)
>     - 高级: 二叉搜索树(binary search tree [red-black tree、AVL])、堆(heap)、并查集(disjoint set)、字典树(Trie), etc
> - 特殊
>     - 位运算(Bitwise)、布隆过滤器(BloomFilter)
>     - LRU Cache

**算法**

> - if-else、switch -> branch
> - for、while loop -> Iteration
> - 递归 Recursion (Divide & Conquer, Backtrace)
> - 搜索 Search: 深度优先搜索(Depth first search)、广度优先搜索(Breadth first search), A*, etc
> - 动态规划 Dynamic Programming
> - 二分查找 Binary Search
> - 贪心 Greedy
> - 数学 Math, 几何 Geometry

##### Deliberate Practicing - 刻意练习

> 对小知识点进行专项的练习
>
> 刻意练习 - 过遍数(五毒神掌)
>
> 练习缺陷、弱点地方

##### Feedback - 反馈

> - 主动型反馈
>     - 高手代码(LeetCode, Github, etc)
> - 被动型反馈
>     - Code review

#### 五毒神掌

**刷题第一遍**

- 5分钟: 读题 + 思考
- 直接看解法
- 背诵、默写好的解法

**刷题第二遍**

- 马上自己写 -> LeetCode提交
- 多种解法比较、体会 -> 优化

**刷题第三遍**

 - 过了一天后 再重复做题
 - 不同解法的熟练程度 -> 专项练习

**刷题第四遍**

- 过了一周 反复回来练习相同题目

**刷题第五遍**

- 面试前一周恢复训练

#### 时间复杂度

> - O(1) -Constant Complexity 常数复杂度
> - O(log n) - Logarithmic Complexity 对数复杂度
> - O(n) - Linear Complexity 线性时间复杂度
> - O(n^2) - N square Complexity 平方
> - O(n^3) - N cubic Complexity 立方
> - O(2^n) - Exponential Growth 指数
> - O(n!) - Factorial 阶乘
>
> 注: 一个程序只看最高复杂度的运算

**运行时间排行**

O(1) < O(log n) < O(n) < O(n log n ) < O(n^2) < O(2^n) < O(n!)

其他时间复杂度

> 二分查找 - O(log n) - Binary Search
>
> 二叉树 - O(n) - Binary tree traversal
>
> 矩阵搜索 - O(n) - Optimal sorted matrix search
>
> 归并排序 - O(n log n) - Merge sort
>
> 
>
> 二叉树遍历 - 前序、中序、后序: O(n)
>
> 图的遍历: O(n)
>
> DFS、BFS: O(n)
>
> 二分查找: O(log n)



#### 栈(Stack)和队列(Queue)

​	**栈: 先进后出 - last in first out(LIFO)** 

```java
// 可实现接口
// Serializable, Cloneable, Iterable<E>, Collection<E>, List<E>, RandomAccess

// public class Stack<E> extends Vector<E>
// Class Stack<E>
Stack<Integer> stack = new Stack<>();
// 判空 - 返回 boolean
stack.empty();
// 查看栈顶元素 - 不修改栈 - 返回E
stack.peek();
// push一个元素进栈 - 返回E
stack.push(E item);
// 从栈顶pop一个元素 - 返回E
stack.pop();
// 查找元素 - 返回int
stack.search(Object o);
```

​	**队列: 先进先出 - first in first out(FIFO)**

```java
// 已知实现类
// AbstractQueue, ArrayBlockingQueue, ArrayDeque, ConcurrentLinkedDeque, ConcurrentLinkedQueue, DelayQueue, LinkedBlockingDeque, LinkedBlockingQueue, LinkedList, LinkedTransferQueue, PriorityBlockingQueue, PriorityQueue, SynchronousQueue

// public interface Queue<E> extends Collection<E>
// Interface Queue<E>
Queue<String> queue = new LinkedList<>();

// 添加元素 - 返回boolean 如果满了则触发异常
queue.add(E e);
// 如果满了返回失败(null)
queue.offer(E e);	
// 删除元素 - 如果空了触发异常
queue.remove();
// 如果空返回失败(null)
queue.poll();		
// 查找元素 - 如果没有元素触发异常 
queue.element();
// 如果没有元素返回失败(null)
queue.peek();
```

***特点***

- 两者添加删除皆为O(1)
- 查询皆为O(n) - 因为是无序的

#### 双端队列(Deque)

​	**两端都可以进出的Queue**

```java
// 已知实现类
// ArrayDeque, ConcurrentLinkedDeque, LinkedBlockingDeque, LinkedList

// public interface Deque<E> extends Queue<E>
// Interface Deque<E>
```

|         | First Element (Head) | First Element (Head) | Last Element (Tail) | Last Element (Tail) |
| :-----: | :------------------: | :------------------: | :-----------------: | :-----------------: |
|         |   Throws exception   |    Special value     |  Throws exception   |    Special value    |
| Insert  |     addFirst(e)      |     offerFirst()     |     addLast(e)      |     offerLast()     |
| Remove  |    removeFirst()     |     pollFirst()      |    removeLast()     |     pollLast()      |
| Examine |      getFirst()      |     peekFirst()      |      getLast()      |     peekLast()      |

(Typora目前好像不支持合并单元格 - 尬)

***特点***

- 插入和删除都是O(1)
- 查询皆为O(n) - 因为是无序的

#### 优先队列(Priority Queue)

- 特点
    - peek() 和 element操作 O(1)
    - 取出和插入操作 O(log n) - 按元素的优先级取出
    - 底层具体实现的数据结构较为多样和复杂: heap(堆, 不一定是二叉树堆, 也有可能是其他堆)、bst、treap

#### 源码个人总结

​	因为个人学Java的时间不长(半个月), 所以可能基础不太好, 写的可能不是完全正确或者很全面. - 请多多指教

##### Deque

> Deque是一个接口, 所以这里看了一下 有一个LinkedList的实现类实现了这个接口. 根据这个接口提供的方法, 看一下具体在LinkedList如何实现.
>
> *addFirst(E e)*
> 从队列的头部插入, 这里调用了linkFirst方法. 
> 将要插入的元素和现有队列存入一个新节点，插入元素的后继指针指向现有队列 
> 这里有一个判断 如果原本队列为空的话 那么插入元素相当于尾节点 否则队列的前驱节点指向新元素  最后size加
>
> *offerFirst(E e)* 
> 实际上调用的是 *addFirst(E e)* 只不过在插入完毕会有一个返回值 返回true
>
> *removeFirst()* - 相当于 *pop()* 
> 首先判断是否为空 如果为空throw new抛出异常
> 如果不为空的话 将头结点的下一个结点的前驱指针置空 头结点前后指针置为null(help GC) 返回头结点元素
>
> *pollFirst()*  
> 实际上和 *removeFirst()* 同理 只不过pollFirst在判空的时候 不是抛出异常 而是返回null
>
> *getFirst()* 
> 判断是否为空 如果为空抛出异常
> 如果不为空的话 返回头节点元素
>
> *peekFirst()* 
> 实际上跟 *getFirst()* 同理 只不过 *peekFirst()* 判空会返回null 并不会抛出异常
>
> *contains(Object o)*
> 通过链表原理遍历 如果找不到则返回-1
>
> **感觉有点像双向链表的实现**
> **实际上应该是在链表的基础上尾节点还有一个尾指针**

##### PriorityQueue

> 继承自AbstractQueue抽象类 通过**二叉最小顶堆**实现 每次取出的元素都是队列中权值最小
> 左节点(parentNo * 2 + 1)
> 右节点(parentNo * 2 + 2)
> 父节点([nodeNo - 1] / 2)
> 所以可以使用数组进行表示
>
> *grow(int minCapacity)*
> 扩容 如果size小于64 则每次扩容添加2个大小, 否则的话每次扩容百分之50 使用 *copyOf(queue, newCapacity)* 扩容
>
> indexOf(Object o) - O(n)
> 遍历数组 找到某个相同的元素返回其下标 找不到则返回-1
>
> *add(E e)* 和 offer(E e) - O(log n)
> 不允许放入null元素
> 如果插入不是首个元素 则需要对堆进行调整 每次跟父节点(**逐层与当前节点的parent**)进行比较 **(parentNo = [nodeNo - 1] / 2)** 调用compare比较器(元素的自然顺序 也就是依靠比较器的顺序), 如果小于父节点则进行交换 直到大于等于父节点为止 由于这里只跟父节点进行比较 所以复杂度为O(logn) 
>
> *element()* 和 *peek()* - O(1)
> 获取但不删除队首元素 队列中权值最小的那个元素 
> 由于堆使用数组进行表示 所以直接返回<u>下标0的元素</u>
>
> *remove()* 和 *poll()* - O(log n)
> 删除会改变队列的结构 所以需要进行调整
> 首先记录<u>下标0的元素</u>进行返回 然后使用队列<u>最后一个元素</u>替换<u>下标0元素</u>的位置 然后 *siftDown(int k, E x)* 方法, 逐层向下与当前节点的左右孩子中较小的那个交换 直到x小于或等于左右孩子中任何一个为止
>
> *remove(Object o)*
> 删除队列中某一个和o相等的元素(如果有多个 只删除一个)
> 首先 *indexOf(Object o)* 遍历一遍数组 找不到则返回false. 否则, 找到满足条件的下标, 如果删除的是最后一个, 则直接置为null, 否则的话, 将最后一个元素替换上来, 使用 *siftDown(int k, E x)*进行调整
>
> *removeEq(Object o)*
> 和 *remove(Object)* 同理 区别是这个使用==作为比较, 而上面使用 *equals()* 进行比较
>
> *contains(Object o)*
> 使用 *indexOf(Object o)* 判断元素是否存在 返回boolean值
>
> **参考了一下网上的博客 进行了一下原理学习(直接看看不太明白)**

