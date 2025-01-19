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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode prev = head;
        int carry = 0;
        while (null != l1 || null != l2) {
            int num = carry;
            if (null != l1) {
                num += l1.val;
                l1 = l1.next;
            }

            if (null != l2) {
                num += l2.val;
                l2 = l2.next;
            }

            if (10 <= num) {
                num -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            prev.next = new ListNode(num);
            prev = prev.next;
        }

        if (1 == carry) {
            prev.next = new ListNode(1);
        }

        return head.next;
    }
}