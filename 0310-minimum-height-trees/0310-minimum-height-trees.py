class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if 1 == n:
            return [0]
        
        if 2 == n:
            return [0, 1]

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

        while True:
            leaves = []
            for number, neighbors in connection.items():
                if 1 == len(neighbors):
                    leaves.append(number)

            rootMaybe = None
            for leaf in leaves:                
                rootMaybe = connection[leaf][0]
                connection[rootMaybe].remove(leaf)
                if 0 == len(connection[rootMaybe]):
                    del connection[rootMaybe]
           
                del connection[leaf]

            if 2 == len(connection):
                roots = []
                for number in connection:
                    roots.append(number)

                return roots

            if 0 == len(connection):
                return [rootMaybe] 