# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val < q.val:
            small = p
            large = q
        else:
            large = p
            small = q
        #print(small, large)

        lca = root
        while True:
            if lca.val > large.val:
                lca = lca.left
                #print('Down left')
            else:
                if lca.val < small.val:
                    lca = lca.right
                    #print('Down right')
                else:
                    break

        return lca