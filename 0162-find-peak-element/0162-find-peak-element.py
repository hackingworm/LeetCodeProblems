class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        begin = 0
        end = len(nums)
        while begin < end:
            middle = (begin + end) // 2
            if (0 == middle or nums[middle - 1] < nums[middle]) and (len(nums) == middle + 1 or nums[middle + 1] < nums[middle]):
                return middle

            if 0 < middle and nums[middle - 1] >= nums[middle]:
                end = middle
            else:
                begin = middle + 1