# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        def largestValuesRecur(nodes: List[TreeNode]) -> List[int]:
            if 0 == len(nodes):
                return []

            largest = nodes[0].val
            for i in nodes[1:]:
                largest = max(largest, i.val)

            newNodes = []
            for i in nodes:
                if None != i.left:
                    newNodes.append(i.left)
                if None != i.right:
                    newNodes.append(i.right)
            
            largests = largestValuesRecur(newNodes)

            #largest = nodes[0].val
            #for i in nodes[1:]:
            #    largest = max(largest, i.val)

            largests.append(largest)

            return largests

        if None == root:
            return []

        largests = largestValuesRecur([root])
        largests.reverse()
        return largests