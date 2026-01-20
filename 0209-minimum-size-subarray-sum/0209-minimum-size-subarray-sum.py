class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        min = len(nums) + 1
        sum = 0
        begin = 0
        for end in range(len(nums)):
            sum += nums[end]
            if target > sum:
                continue
            
            while sum >= target + nums[begin]:
                sum -= nums[begin]
                begin += 1

            if min > end - begin + 1:
                min = end - begin + 1

        if len(nums) + 1 == min:
            min = 0

        return min