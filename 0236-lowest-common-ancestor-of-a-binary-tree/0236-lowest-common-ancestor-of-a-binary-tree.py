# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class WorkingNode:
    def __init__(self, parent: 'WorkingNode', treeNode: 'TreeNode', visited: bool):
        self.parent = parent
        self.treeNode = treeNode
        self.visited = visited

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        candidate = None
        nodes = [WorkingNode(None, root, False)]
        while 0 < len(nodes):
            #index = len(nodes) - 1
            node = nodes[len(nodes) - 1]

            if node.visited:
                if node == candidate:
                    candidate = candidate.parent

                nodes.pop()
                continue

            node.visited = True

            if node.treeNode == p or node.treeNode == q:
                if None != candidate:
                    #print(candidate.treeNode.val, node.treeNode.val)
                    return candidate.treeNode
                
                #print(node.treeNode.val)
                candidate = node

            if None != node.treeNode.right:
                nodes.append(WorkingNode(node, node.treeNode.right, False))

            if None != node.treeNode.left:
                nodes.append(WorkingNode(node, node.treeNode.left, False))