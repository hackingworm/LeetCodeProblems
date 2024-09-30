class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        dict = {}
        for i in range(len(nums)):
            dict[nums[i]] = i
        # print(dict)

        triples = set()
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                k = dict.get(-nums[i] - nums[j])
                if None == k:
                    continue

                if j < k:
                    #triple = [nums[i], nums[j], nums[k]]
                    #triple.sort()
                    #triples.add((triple[0], triple[1], triple[2]))
                    triples.add((nums[i], nums[j], nums[k]))

        # print(triples)
        return list(triples)

        '''
        triples = set()
        nums.sort()
        for i in range(len(nums) - 1):
            j = i + 1
            k = len(nums) - 1
            while j < k:
                if 0 > nums[i] + nums[j] + nums[k]:
                    j += 1
                elif 0 < nums[i] + nums[j] + nums[k]:
                    k -= 1
                else:
                    triples.add((nums[i], nums[j], nums[k]))
                    j += 1
                    k -= 1
    
        return list(triples)
        '''