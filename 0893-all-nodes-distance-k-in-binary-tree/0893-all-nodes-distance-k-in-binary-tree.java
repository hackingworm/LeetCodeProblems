/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> distanceK(TreeNode root, int k) {
        List<TreeNode> atCurLevel = new ArrayList<>();
        atCurLevel.add(root);
        for (int i = 0; i < k && 0 < atCurLevel.size(); i++) {
            List<TreeNode> atNextLevel = new ArrayList<>();
            for (int j = 0; j < atCurLevel.size(); j++) {
                TreeNode node = atCurLevel.get(j);

                if (null != node.left) {
                    atNextLevel.add(node.left);
                }

                if (null != node.right) {
                    atNextLevel.add(node.right);
                }
            }
            
            atCurLevel = atNextLevel;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < atCurLevel.size(); i++) {
            result.add(atCurLevel.get(i).val);
        }

        return result;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> ancestors = new ArrayList<>();
        TreeNode node = root;
        while (target != node) {
            if (null == node.left && null == node.right) {
                TreeNode parent = null;
                while (0 < ancestors.size()) {
                    parent = ancestors.get(ancestors.size() - 1);
                    if (node == parent.left && null != parent.right) {
                        break;
                    }

                    node = parent;
                    ancestors.remove(parent);
                }

                node = parent.right;
                continue;
            }

            ancestors.add(node);
            if (null != node.left) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        List<Integer> result = distanceK(node, k);
        for (int i = 0; i < k && i < ancestors.size(); i++) {
            TreeNode parent = ancestors.get(ancestors.size() - i - 1);

            if (k - 1 == i) {
                result.add(parent.val);
                continue;
            }

            if (node == parent.left && null != parent.right) {
                result.addAll(distanceK(parent.right, k - i - 2));
            }

            if (node == parent.right && null != parent.left) {
                result.addAll(distanceK(parent.left, k - i - 2));
            }

            node = parent;
        }

        return result;
    }
}