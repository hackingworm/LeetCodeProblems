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
            rootMaybe = None
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

            if 2 == len(connection):
                roots = []
                for number in connection:
                    roots.append(number)

                return roots

            if 0 == len(connection):
                return [rootMaybe] 

        '''
        minHeight = n
        trees = set()

        for i in range(n):
            height = 0
            visited = [False] * n
            visited[i] = True
            currents = set()
            currents.add(i)
            count = 1
            while n > count and minHeight > height:
                nexts = set()
                for current in currents:
                    for j in map[current]:
                        if not visited[j]:
                            nexts.add(j)
                            visited[j] = True
                            count += 1

                #print(i, currents, nexts)

                currents = nexts
                height += 1

            #print(i, height)

            if n > count:
                continue

            if minHeight > height:
                minHeight = height
                trees = set()

            trees.add(i)
        
        return list(trees)
        '''