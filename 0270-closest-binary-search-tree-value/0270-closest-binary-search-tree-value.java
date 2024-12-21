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
    public int closestValue(TreeNode root, double target) {
        double closestDiff = Math.abs(root.val - target);
        int closest = root.val;
        TreeNode current = root;
        while (null != current) {
            double diff = current.val - target;
            if (0 == diff) {
                return current.val;
            }

            if (Math.abs(diff) < closestDiff) {
                // System.out.println("closestDiff: " + closestDiff + " diff: " + diff + " closest:" + closest + " current: " + current.val);
                closestDiff = Math.abs(diff);
                closest = current.val;
            }
            
            if (Math.abs(diff) == closestDiff && current.val < closest) {
                closest = current.val;
            }

            if (0 < diff) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return closest;
    }
}