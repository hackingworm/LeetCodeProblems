import heapq

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        kLargests = [0] * k
        for i in range(k):
            kLargests[i] = nums[i]
        heapq.heapify(kLargests)

        for i in range(k, len(nums)):
            if kLargests[0] < nums[i]:
                heapq.heappushpop(kLargests, nums[i])

        return kLargests[0]