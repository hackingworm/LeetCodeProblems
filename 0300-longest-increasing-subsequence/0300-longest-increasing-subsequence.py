class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        longest = 1
        largest = nums[-1]
        length = [1] * len(nums)
        for i in range(len(nums) - 2, -1, -1):
            if largest <= nums[i]:
                largest = nums[i]
                continue

            l = 1
            for j in range(i + 1, len(nums)):
                if nums[i] < nums[j] and l < length[j]:
                    l = length[j]
                    if longest == l:
                        break

            length[i] += l
            if longest < length[i]:
                longest = length[i] 

        return longest