class Solution:
    def insert(self, num: int, sorted: List[int]):
        begin = 0
        end = len(sorted)
        while begin < end:
            middle = (begin + end) // 2
            if num < sorted[middle]:
                begin = middle + 1
            elif num > sorted[middle]:
                end = middle
            else:
                begin = middle + 1
                end = middle

        sorted.insert(begin, num)

    def findKthLargest(self, nums: List[int], k: int) -> int:
        kLargests = []

        for num in nums:
            if k > len(kLargests) or kLargests[-1] < num:
                if k == len(kLargests):
                    kLargests.pop()
                self.insert(num, kLargests)

        return kLargests[-1]