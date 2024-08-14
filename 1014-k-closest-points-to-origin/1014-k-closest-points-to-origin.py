class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        eudists = []
        for point in points:
            eudists.append([point[0] ** 2 + point[1] ** 2, point])
        eudists.sort()
        #print(eudists)
        
        results = [[0, 0]] * k
        for i in range(k):
            results[i] = eudists[i][1]

        return results