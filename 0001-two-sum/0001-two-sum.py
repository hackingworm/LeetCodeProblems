class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict = {}
        for i in range(len(nums)):
            dict[nums[i]] = i

        for i in range(len(nums)):
            j = dict.get(target - nums[i])
            if None == j:
                continue

            if i != j:
                return([i, j])