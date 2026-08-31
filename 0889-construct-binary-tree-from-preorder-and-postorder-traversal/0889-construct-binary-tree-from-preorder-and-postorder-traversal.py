# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def constructFromPrePost(self, preorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if len(preorder) == 0:
            return None

        current = root = TreeNode(preorder[0])
        i = 1
        while i < len(preorder) and preorder[i] == postorder[len(postorder) - i - 1]:
            current.left = TreeNode(preorder[i])
            current = current.left
            i += 1

        if len(preorder) == i:
            return root

        j = 0
        while preorder[i] != postorder[j]:
            j += 1  

        current.left = self.constructFromPrePost(preorder[i: i + j + 1], postorder[:j + 1])
        current.right = self.constructFromPrePost(preorder[i + j + 1:], postorder[j + 1: len(postorder) - i])

        return root