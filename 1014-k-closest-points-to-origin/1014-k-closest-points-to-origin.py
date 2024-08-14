class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        eudists = [[0, [0, 0]]] * len(points)
        for i in range(len(points)):
            eudists[i] = [points[i][0] ** 2 + points[i][1] ** 2, points[i]]
        eudists.sort()
        
        results = [[0, 0]] * k
        for i in range(k):
            results[i] = eudists[i][1]
        return results