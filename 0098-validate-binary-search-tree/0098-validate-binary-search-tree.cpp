/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isValidBST(TreeNode* root, int& minimum, int& maximum) {
        if (root->left) {
            int min, max;
            if (!isValidBST(root->left, min, max) || max >= root->val) {
                return false;
            }

            minimum = min;
        } else {
            minimum = root->val;
        }

        if (root->right) {
            int min, max;
            if (!isValidBST(root->right, min, max) || min <= root->val) {
                return false;
            }

            maximum = max;
        } else {
            maximum = root->val;
        }

        return true;
    }

    bool isValidBST(TreeNode* root) {
        int min, max;
        return isValidBST(root, min, max);
    }
};