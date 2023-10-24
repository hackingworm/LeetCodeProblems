# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        def largestValue(start: int):
            largest = nodes[start].val
            for i in nodes[start + 1:]:
                largest = max(largest, i.val)
            largests.append(largest)

            newStart = len(nodes)
            for i in nodes[start:]:
                if None != i.left:
                    nodes.append(i.left)
                if None != i.right:
                    nodes.append(i.right)
            
            if len(nodes) > newStart:
                largestValue(newStart)

        largests = []
        nodes = []

        if None != root:
            nodes.append(root)
            largestValue(0)

        return largests