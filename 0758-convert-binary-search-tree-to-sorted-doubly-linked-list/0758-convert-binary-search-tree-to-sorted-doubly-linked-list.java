/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    void printDLL(Node head) {
        if (null == head) {
            return;
        }

        System.out.print(head.val);
        for (Node node = head.right; node != head; node = node.right) {
            System.out.print("->" + node.val);
        }
        System.out.println();

        System.out.print(head.val);
        for (Node node = head.left; node != head; node = node.left) {
            System.out.print("->" + node.val);
        }
        System.out.println();
    }

    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }

        Node head;
        if (null != root.left) {
            Node left = treeToDoublyList(root.left);
            root.left = left.left;
            head = left;
            left.left.right = root;
        } else {
            head = root;
        }

        if (null != root.right) {
            Node right = treeToDoublyList(root.right);
            root.right = right;
            head.left = right.left;
            right.left.right = head;
            right.left = root;
        } else {
            root.right = head;
            head.left = root;
        }

        // printDLL(head);
        return head;
    }
}