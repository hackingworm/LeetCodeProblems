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
    public boolean isCompleteTree(TreeNode root) {
        boolean hasNullChild = false;
        int count = 1;
        TreeNode[] currentLevel = new TreeNode[1];
        currentLevel[0] = root;
        while (0 < count) {
            int newCount = 0;
            TreeNode[] nextLevel = new TreeNode[currentLevel.length * 2];
            for (int i = 0; i < count; i++) {
                TreeNode node = currentLevel[i];

                if (null == node.left) {
                    hasNullChild = true;
                } else {
                    if (hasNullChild) {
                        return false;
                    }

                    nextLevel[newCount++] = node.left;
                }

                if (null == node.right) {
                    hasNullChild = true;
                } else {
                    if (hasNullChild) {
                        return false;
                    }

                    nextLevel[newCount++] = node.right;
                }
            }

            count = newCount;
            currentLevel = nextLevel;
        }

        return true;
    }
}