### Hash table

<u>**Hash - Set - Map**</u>

- 概念

    - 根据关键码值而直接进行访问的数据结构
    - 通过把关键码值映射到表中一个位置来访问记录
    - 映射函数 - 散列函数
    - 存放记录的数组 - 哈希表(散列表)

- 时空复杂度

    - 平均 - 查找插入删除都是O(1)
    - 最坏 - 当发生大几率哈希碰撞时 退化成O(n)

- Java实现

    - Map 

        - key-value对 key不重复
        - new HashMap() / new TreeMap()
        - set()、get()、containsKey()、size()、clear()

    - Set

        - 不重复的元素集合
        - new HashSet() / new TreeSet()
        - add()、delete()、hash()

    - 实现

        - Hash Table

            - 平均 - 查找插入删除都是O(1)
            - 最坏 - 当发生大几率哈希碰撞时 退化成O(n)

        - Red-Black Tree

            - 平均和最坏 - 皆为O(logn)

### Tree

**<u>Tree - Binary Tree - Binary Sort Tree</u>**

> LinkedList 是特殊化的 Tree
> Tree 是特殊化的 Graph

- 遍历
    - 前序 - 根左右
    - 中序 - 左根右
    - 后序 - 左右根

Binary Sort Tree

​	二叉搜索树(二叉排序树、有序二叉树、排序二叉树)指一棵空树或者具有以下性质:

	1. 左子树上所有节点的值均小于它根节点的值
 	2. 右子树上所有节点的值均大于它根节点的值
 	3. 以此类推: 左右子树也称为二叉排序树!(重复性)
 	4. 中序遍历 - 相当于升序

- 时空复杂度
    - 平均 - 查询添加删除都是O(logn)
    - 最坏 - 当树只往一边偏移 为O(n)

### Heap

- 可以迅速找到一堆数中的最大值或者最小值的数据结构
- 将根节点最大的为大根堆(最大堆)
- 将根节点最小的为小根堆(最小堆)
- Heap实现方式
    - 二叉堆(比较常见 但并不是说时间复杂度比较好)
    - 斐波那契堆
    - 时空复杂度
        - find-max(min): O(1)
        - delete-max(min): O(logn)
        - insert(create): O(logn) or O(1)

**<u>Binary Heap</u>**

- 通过二叉树实现(不是二叉搜索树)
- Java - PriorityQueue
- 性质
    - 一棵完全树
    - 树的任意节点总是>=其子节点的值
- 实现
    - 一般通过数组实现
    - 顶堆元素: 堆[0]
    - 索引为 i 的左孩子索引 - (2 * i  - 1)
    - 索引为 i 的右孩子索引 - (2 * i  - 2)
    - 索引为 i 的父节点索引 floor((i - 1) / 2)
- 操作 - 之前笔记对源码总结过 这里简单叙述下
    - Insert(logN) 新元素一律插入到尾部 依次向上调整(最多直到根为止) - HeapifyUp
    - Delet Max 将堆尾元素替换到顶部 - 依次向下调整(最多直到堆尾为止) - HeapifyDown

### Source Summary

#### HashMap

> key/value结构 非线程安全 不保证元素存储顺序
> 由 (数组 + 链表 + 红黑树)  的复杂结构
> 当链表元素个数达到一定数量后 会转换成红黑树
>
> 当一个桶中的元素个数大于等于8时进行树化
> static final int TREEIFY_THRESHOLD = 8; 
>
> 当一个桶中的元素个数小于等于6时把树转化为链表
> static final int UNTREEIFY_THRESHOLD = 6;
>
> 当桶的个数达到64的时候才进行树化 
> static final int MIN_TREEIFY_CAPACITY = 64;
>
> 采用单链表节点
> 	final int hash; // 存储key计算的hash值
> 	final K key; 
> 	V value;
> 	Node<K,V> next;
>
> *resize()*
> 扩容
>  第一次插入元素 默认大小为16 每次扩容新容量等于旧容量的两倍 最后搬移元素，原链表分化成两个链表，低位链表存储在原来桶的位置，高位链表搬移到原来桶的位置加旧容量的位置
>
> *equals(Object o)*
> 判断key-value是否相同 先地址后调用对象的 *equals()* 方法
>
> *get(Object key)*
> 通过key值 返回value值 调用 *getNode(int hash, Object key)*
> 实现: 通过hash值在数组中寻找, 并判断链表第一个节点的key是否等于当前搜索key值 如果是的话返回value值 否则的话 通过链表 依次往后查找 直到找到为止 如果找不到 返回null
>
> *put(K key, V value)*
> 添加key和value值 调用 *putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict)*
> 通过key的hash值找到数组对应位置, 如果该位置没有元素, 则直接放置在此处 否则的话以链表的形式放置在尾部.修改size
>
> *remove(Object key)*
> 删除key值
> 先通过hash值找到元素所在的节点 如果找到的节点是数组中第一个节点 则将第二个移到第一个上 否则的话 按链表删除节点 修改size
>
> 
>
> **由于Java基础有限 所以有些查找过Google讲解 请多多指教**

