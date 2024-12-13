# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def heightOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        if None == root.left and None == root.right:
            return 0
            
        if None == root.left:
            hLeft = 0
        else:
            hLeft = self.heightOfBinaryTree(root.left)

        if None == root.right:
            hRight = 0
        else:
            hRight = self.heightOfBinaryTree(root.right)

        return max(hLeft, hRight) + 1

        
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        if None == root or None == root.left and None == root.right:
            return 0

        onlyChild = None
        if None == root.left:
            onlyChild = root.right

        if None == root.right:
            onlyChild = root.left

        if None != onlyChild:
            diameter = self.heightOfBinaryTree(onlyChild) + 1

            childDiameter = self.diameterOfBinaryTree(onlyChild)
            if childDiameter > diameter:
                diameter = childDiameter
            return diameter

        diameter = self.heightOfBinaryTree(root.left) + self.heightOfBinaryTree(root.right) + 2

        childDiameter = self.diameterOfBinaryTree(root.left)
        if childDiameter > diameter:
            diameter = childDiameter
        
        childDiameter = self.diameterOfBinaryTree(root.right)
        if childDiameter > diameter:
            diameter = childDiameter

        return diameter