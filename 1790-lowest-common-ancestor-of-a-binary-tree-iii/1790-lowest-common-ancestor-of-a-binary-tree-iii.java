/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    private Stack<Node> ancestors(Node node) {
        Stack<Node> ancestors = new Stack<>();
        while (null != node) {
            ancestors.push(node);
            node = node.parent;
        }

        return ancestors;
    }

    public Node lowestCommonAncestor(Node p, Node q) {
        Stack<Node>
            pAncestors = ancestors(p),
            qAncestors = ancestors(q);

        Node lcAncestor = null;
        while(!pAncestors.empty() && !qAncestors.empty()) {
            Node ancestor = pAncestors.pop();
            if (qAncestors.pop() != ancestor) {
                break;
            }

            lcAncestor = ancestor;
        }

        return lcAncestor;
    }
}