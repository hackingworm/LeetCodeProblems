class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        '''
        rootMaybe = 0
        while True:
            if 0 == len(edges):
                return [rootMaybe]
                
            if 1 == len(edges):
                return edges[0]

            map = dict()
            for edge in edges:
                for i in range(2):
                    if edge[i] in map:
                        rootMaybe = edge[i]
                        map[rootMaybe] = None
                    else:
                        map[edge[i]] = edge

            for number, edge in map.items():
                if edge:
                    edges.remove(edge)
        '''

        connection = dict()
        for edge in edges:
            if edge[0] in connection:
                connection[edge[0]].append(edge[1])
            else:
                connection[edge[0]] = [edge[1]]

            if edge[1] in connection:
                connection[edge[1]].append(edge[0])
            else:
                connection[edge[1]] = [edge[0]]

        rootMaybe = 0
        while True:
            if 0 == len(connection):
                return [rootMaybe]

            if 2 == len(connection):
                roots = []
                for number in connection:
                    roots.append(number)
                return roots
    
            leaves = []
            for number, neighbors in connection.items():
                if 1 == len(neighbors):
                    leaves.append(number)

            for leaf in leaves:                
                rootMaybe = connection[leaf][0]
                connection[rootMaybe].remove(leaf)
                if 0 == len(connection[rootMaybe]):
                    del connection[rootMaybe]
           
                del connection[leaf]
