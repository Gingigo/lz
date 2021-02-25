package leetcode.leetcode.editor.cn;
// ToDo-Lee


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class _19_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode nBefore = head;
        ListNode node = head;
        for (int i = 0; i < n; i++) {
            temp = temp.next;
        }
        if (temp == null) {
   /*   if (head.next == null) {
        head = null;
        return head;
      }*/
            return head.next;
        } else {
            temp = temp.next;
            nBefore = nBefore.next;
        }
        while (temp != null) {
            temp = temp.next;
            nBefore = nBefore.next;
            node = node.next;
        }
        node.next = nBefore.next;
        return head;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 970 👎 0

