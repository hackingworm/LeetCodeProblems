class Solution:
    def findMin(self, nums: List[int]) -> int:
        begin = 0
        end = len(nums) - 1
        while True:
            if nums[begin] == nums[end]:
                value = nums[begin]
                while begin < end and value == nums[begin + 1]:
                    begin += 1
                
                while begin < end and value == nums[end - 1]:
                    end -= 1

                if begin == end:
                    break

            if nums[begin] < nums[end]:
                break

            middle = (begin + end) // 2
            if nums[begin] > nums[middle]:
                end = middle
            else:
                begin = middle + 1

        return nums[begin]