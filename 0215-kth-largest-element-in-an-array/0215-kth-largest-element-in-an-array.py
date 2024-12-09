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
                begin = middle
                end = middle

        if (8221 == num):
            print(num, begin, len(sorted))
            for i in range(begin - 1, begin + 4):
                print(sorted[i])
        sorted.insert(begin, num)

        '''
        i = len(sorted)
        while 0 < i and sorted[i - 1] < num:
            i -= 1
        
        if (8221 == num):
            print(num, i, len(sorted))
            for j in range(i - 2, i + 3):
                print(sorted[j])
        #sorted.insert(i, num)
        '''

    def findKthLargest(self, nums: List[int], k: int) -> int:
        kLargests = []

        for num in nums:
            if k > len(kLargests) or kLargests[-1] < num:
                if k == len(kLargests):
                    kLargests.pop()
                self.insert(num, kLargests)

        return kLargests[-1]