class Solution:
    def getSortedUnique(self, nums: List[int]) -> List[int]:
        unique = set()
        for num in nums:
            if num not in unique:
                unique.add(num)
        return sorted(list(unique))
    
    def minOperations(self, nums: List[int]) -> int:
        ops = len(nums) - 1
        sortedUnique = self.getSortedUnique(nums)
        print(sortedUnique)
        for l in range(len(sortedUnique)):
            b = l
            r = len(sortedUnique)
            while b < r - 1:
                m = (b + r) >> 1
                if (sortedUnique[m] < sortedUnique[l] + len(nums)):
                    b = m
                else:
                    r = m

            #r = l
            #while r < len(sortedUnique) and sortedUnique[r] < sortedUnique[l] + len(nums):
            #    r += 1

            print(sortedUnique[l], l, r, len(nums) - (r - l))
            ops = min(len(nums) - (r - l), ops)

        return ops
