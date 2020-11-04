//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1177 👎 0


  
package leetcode.editor.cn;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 1. 迭代 O(m + n)
            ListNode ans = new ListNode(-1);
            ListNode cur = ans;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            // l1 或者 l2 有一个未合并完 最后补上
            cur.next = l1 == null ? l2 : l1;
            return ans.next;
            // 2. 递归 O(m + n)
            // terminator
            // 当前对比的两个节点 如果有一个为空 则返回另一个
            /*
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            } else if (l1.val < l2.val) {
                // process
                // drill down
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                // process
                // drill down
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
             */
            // reverse states
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}