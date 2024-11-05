class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        valDict = {}
        i = 0
        while len(nums) > i:
            num = nums[i]
            if num in valDict:
                if 0 == num and 3 == valDict[num] or 0 != num and 2 == valDict[num]:
                    nums.remove(num)
                    continue
                else:
                    valDict[num] += 1
            else:
                valDict[num] = 1

            i += 1

        #print(nums, valDict)

        triples = set()
        for i in range(len(nums)):
            valDict[nums[i]] -= 1
            for j in range(len(nums)):
                if 0 == valDict[nums[j]] or nums[i] > nums[j]:
                    continue

                valDict[nums[j]] -= 1
                val = -nums[i] - nums[j]
                if nums[j] <= val and val in valDict and 0 < valDict[val]:
                    triples.add((nums[i], nums[j], val))
                valDict[nums[j]] += 1
            valDict[nums[i]] += 1

        return list(triples)

        '''
        dict = {}
        #nums.sort()
        for i in range(len(nums)):
            dict[nums[i]] = i

        triples = set()
        for i in range(len(nums)):
            for j in range(len(nums)):
                if j == i or nums[j] < nums[i]:
                    continue
                
                k = dict.get(-nums[i] - nums[j])
                if None == k:
                    continue

                if k != i and k != j and nums[k] >= nums[j]:
                    triples.add((nums[i], nums[j], nums[k]))

        return list(triples)
        '''

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