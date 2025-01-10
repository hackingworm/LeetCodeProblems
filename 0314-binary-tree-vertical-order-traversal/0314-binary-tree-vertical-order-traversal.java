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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<Integer>());

        TreeNode[] queue = new TreeNode[1];
        queue[0] = root;
        int[] distr = new int[1];
        distr[0] = 0;
        int nonempties = 1;

        while (0 < nonempties) {
            TreeNode[] queueNext = new TreeNode[queue.length * 2];
            int[] distrNext = new int[distr.length * 2];
            nonempties = 0;
            
            for (int i = 0; i < queue.length; i++) {
                distrNext[2 * i] = distr[i];
                distrNext[2 * i + 1] = distr[i] + 2;

                TreeNode node = queue[i];
                if (null == node) {
                    continue;
                }

                results.get(distr[i]).add(node.val);
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
            distr = distrNext;
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