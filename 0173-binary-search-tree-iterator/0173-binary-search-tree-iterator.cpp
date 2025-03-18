/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class BSTIterator {
    stack<TreeNode*> nt;

public:
    BSTIterator(TreeNode* root) {
        for (TreeNode* node = root; node; node = node->left) {
            nt.push(node);
        }
    }

    int next() {
        TreeNode* top = nt.top();
        nt.pop();
        for (TreeNode* node = top->right; node; node = node->left) {
            nt.push(node);
        }

        return top->val;
    }

    bool hasNext() { return !nt.empty(); }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */