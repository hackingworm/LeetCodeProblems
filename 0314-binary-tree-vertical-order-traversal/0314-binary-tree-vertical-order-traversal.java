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
    int numOfOnes(int num) {
        int count = 0;
        while (0 < num) {
            if (1 == num % 2) {
                count++;
            }

            num >>= 1;
        }

        return count;
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<Integer>());

        TreeNode[] queue = new TreeNode[1];
        queue[0] = root;
        int nonempties = 1;

        while (0 < nonempties) {
            TreeNode[] queueNext = new TreeNode[queue.length * 2];
            nonempties = 0;
            
            for (int i = 0; i < queue.length; i++) {
                TreeNode node = queue[i];
                if (null == node) {
                    continue;
                }

                results.get(numOfOnes(i) * 2).add(node.val);
                if (null != node.left) {
                    queueNext[i * 2] = node.left;
                    nonempties++;
                }
                
                if (null != node.right) {
                    queueNext[i * 2 + 1] = node.right;
                    nonempties++;
                }
            }

            results.add(0, new ArrayList<Integer>());
            results.add(results.size(), new ArrayList<Integer>());
            queue = queueNext;
        }
        
        for (int i = 0; i < results.size();) {
            if (results.get(i).isEmpty()) {
                results.remove(i);
            } else {
                i++;
            }
        }

        return results;
    }
}