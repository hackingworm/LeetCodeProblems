class Solution:  
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        ops = n - 1
        sortedNums = sorted(set(nums))
        j = 1

        for i in range(len(sortedNums)):
            while len(sortedNums) > j and n + sortedNums[i] > sortedNums[j]:
                j += 1

            ops = min(ops, n - (j - i))

        return ops 
