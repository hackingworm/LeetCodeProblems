class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        euDists = {}

        for point in points:
            euDist = point[0] ** 2 + point[1] ** 2
            if None == euDists.get(euDist):
               euDists[euDist] = []
            euDists[euDist].append(point)
        
        #print(euDists)
        sortedEuDists = dict(sorted(euDists.items(), key = lambda item: item[0]))
        #print(sortedEuDists)

        results = [[0, 0]] * k
        count = 0
        for ptsList in sortedEuDists.values():
            if k == count:
                break
            for pts in ptsList:
                if k == count:
                    break
                results[count] = pts
                count += 1

        return results
    
        '''
        eudists = [[0, [0, 0]]] * len(points)
        for i in range(len(points)):
            eudists[i] = [points[i][0] ** 2 + points[i][1] ** 2, points[i]]
        eudists.sort()
        
        results = [[0, 0]] * k
        for i in range(k):
            results[i] = eudists[i][1]
        return results
        '''