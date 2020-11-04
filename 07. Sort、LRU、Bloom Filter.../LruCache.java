//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 896 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache {
    public static void main(String[] args) {
//        Solution solution = new LruCache().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
            public  DLinkedNode () {}
            public  DLinkedNode (int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        private int size, capacity;
        private DLinkedNode head, tail;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.head = new DLinkedNode();
            this.tail = new DLinkedNode();
            this.head.next = tail;
            this.tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            } else {
                // 将节点更新到双链表头部
                moveToHead(node);
                // 返回value值
                return node.value;
            }
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                // 如果为空 直接添加
                // 添加之后判断是否超出空间大小
                // 如果超出空间大小 删除最尾部节点
                node = new DLinkedNode(key, value);
                addToHead(node);
                cache.put(key, node);
                size ++;
                if (size > capacity) {
                    DLinkedNode last = removeTail();
                    cache.remove(last.key);
                    size --;
                }
            } else {
                // 如果不为空 则更新node.value
                // 将对应节点更新到链表头部
                node.value = value;
                moveToHead(node);
            }
        }

        private void moveToHead(DLinkedNode node) {
            // 将节点刷新到链表头部
                // 删除对应节点
                // 在头部添加
            removeNode(node);
            addToHead(node);
        }

        private void addToHead(DLinkedNode node) {
            // 将节点添加到链表头部
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            // 删除当前节点
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private DLinkedNode removeTail() {
            // 删除最近最少使用节点(链表尾部节点)
                // 得到tail的前一个节点
                // 进行删除
                // 返回 方便在哈希表中进行删除
            DLinkedNode prev = tail.prev;
            removeNode(prev);
            return prev;
        }





    }
    /*
    // 借助 LinkedHashMap accessOrder
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;
        public LRUCache(int capacity) {
            // 第三个参数 accessOrder提供查询的时候 是否开启排序模式
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            // 这里在进行get的时候 会调用一个 afterNodeAccess() 函数
            // 也就是说 如果开启了排序模式 每次使用get的时候 会将当前访问的节点 重新进行排序
            // 放到双向链表的头部
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > this.capacity;
        }
    }
     */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}