class Solution:
    def findMin(self, nums: List[int]) -> int:
        begin = 0
        end = len(nums) - 1
        while begin < end and nums[begin] > nums[end]:
            middle = (begin + end) // 2
            if nums[begin] <= nums[middle]:
                begin = middle + 1
            else:
                end = middle

        return nums[begin]

        