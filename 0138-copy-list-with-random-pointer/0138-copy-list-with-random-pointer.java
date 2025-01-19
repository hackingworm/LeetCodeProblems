/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }

        Node copiedHead = new Node(head.val);
        for (Node cur = head.next, copiedCur = copiedHead; null != cur;
            cur = cur.next, copiedCur = copiedCur.next) {
            copiedCur.next = new Node(cur.val);
        }

        for (Node cur = head, copiedCur = copiedHead; cur != null;
            cur = cur.next, copiedCur = copiedCur.next) {
            Node target, copiedTarget;
            for (target = head, copiedTarget = copiedHead;
                null != target && cur.random != target;
                target = target.next, copiedTarget = copiedTarget.next);
            copiedCur.random = copiedTarget;
        }

        return copiedHead;
    }
}