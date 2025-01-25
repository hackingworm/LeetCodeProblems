/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sumNumber(TreeNode root, int ancestry) {
        ancestry *= 10;
        ancestry += root.val;

        if (null == root.left && null == root.right) {
            return ancestry; 
        }

        int sum = 0;

        if (null != root.left) {
            sum += sumNumber(root.left, ancestry);
        }

        if (null != root.right) {
            sum += sumNumber(root.right, ancestry);
        }

        return sum;
    }

    public int sumNumbers(TreeNode root) {
        return sumNumber(root, 0);
    }
}