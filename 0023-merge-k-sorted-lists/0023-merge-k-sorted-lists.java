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
    class Heap {
        ListNode[] lists;
        int size;
        
        int compare(int index1, int index2) {
            return lists[index2].val - lists[index1].val;
        }

        void relocate(int index) {
            while (size / 2 > index) {
                int target = index * 2 + 1;
                if (size > target + 1 && (0 < compare(target + 1, target))) target++;
                if (0 <= compare(index, target))
                    break;
                ListNode tmp = lists[index];
                lists[index] = lists[target];
                lists[target] = tmp;
                index = target;
            }
        }

        ListNode getTop() {
            if (0 == size) return null;        
            ListNode top = lists[0];
            if (null == lists[0].next) {
                lists[0] = lists[size - 1];
                size--;
            } else lists[0] = lists[0].next;
            relocate(0);
            top.next = null;
            return top;
        }

        Heap(ListNode[] lists) {
            this.lists = new ListNode[lists.length];
            size = 0;
            for (int i = 0; i < lists.length; i++)
                if (null != lists[i]) this.lists[size++] = lists[i];

            for (int i = size / 2 - 1; i >= 0; i--) relocate(i);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (0 == lists.length) return null;
        ListNode head = new ListNode(0);
        ListNode current = head;
        Heap heap = new Heap(lists);
        for (ListNode node = heap.getTop(); null != node; node = heap.getTop()) {
            current.next = node;
            current = node;
        }
        return head.next;
    }
}