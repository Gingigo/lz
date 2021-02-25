package leetcode.leetcode.editor.cn;
//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// Example: 
//
// 
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
// 
// Related Topics 链表 数学

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class _2_AddTwoNumbers {
    public static void main(String[] args) {
    }

    public int whichStrPosition(String str, int count, String pat) {
        Pattern pattern = Pattern.compile(pat);
        Matcher findMatcher = pattern.matcher(str);
        int number = 0;
        while (findMatcher.find()) {
            number++;
            if (number == count) {
                break;
            }
        }
        return findMatcher.start();
    }


    /*NOTE 依次遍历 相加,判断是否为Null*/
    void add(ListNode l1, ListNode l2) {

        ListNode temp = new ListNode(0);
        ListNode p = l1, q = l2, curr = temp;
        int carry = 0;
        while (p != null || q != null) {
            //美观写法
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int target = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
            curr.next = new ListNode(target);
            curr = curr.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(1);
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

