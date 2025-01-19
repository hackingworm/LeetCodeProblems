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

        return head;
    }
}