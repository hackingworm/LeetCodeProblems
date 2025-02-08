"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None

        pos = {}
        index = 0

        print(node.val)
        pos[node.val] = index

        first = Node(node.val)
        cq = [first]

        index += 1
        #node.val = -node.val
        q = [node]

        begin = 0
        end = index
        while begin < end:
            for i in range(begin, end):
                cloned = cq[i]
                cloned.neighbors = []
                for j in range(len(q[i].neighbors)):
                    neighbor = q[i].neighbors[j]
                    if neighbor.val in pos:
                        cloned.neighbors.append(cq[pos[neighbor.val]])
                    else:
                        print(neighbor.val)
                        pos[neighbor.val] = index
                        cq.append(Node(neighbor.val))
                        cloned.neighbors.append(cq[pos[neighbor.val]])

                        index += 1
                        #neighbor.val = -neighbor.val
                        q.append(neighbor)
        
            begin = end
            end = index

        print(pos)

        '''
        for i in range(len(q)):
            orig = q[i]
            cloned = cq[i]
            cloned.neightbors = []
            for neighbor in orig.neighbors:
                cloned.neighbors.append(cq[pos[-neighbor.val]])
        '''    

        return first