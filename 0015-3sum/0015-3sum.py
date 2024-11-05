class Solution:
    def threeSum(self, origNums: List[int]) -> List[List[int]]:
        nums = []
        valDict = {}
        for num in origNums:
            if num in valDict:
                valDict[num] += 1
            else:
                valDict[num] = 1

            if 3 > valDict[num] or 4 > valDict[num] and 0 == num:
                nums.append(num) 

        print(nums, valDict)

        triples = set()
        for i in range(len(nums)):
            valDict[nums[i]] -= 1
            for j in range(len(nums)):
                if i == j or nums[i] > nums[j]:
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