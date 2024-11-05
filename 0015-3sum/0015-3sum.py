class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        #'''
        newNums = []
        valDict = {}
        for num in nums:
            if num in valDict:
                valDict[num] += 1
            else:
                valDict[num] = 1

            if 3 > valDict[num] or 4 > valDict[num] and 0 == num:
                newNums.append(num) 

        print(newNums, valDict)

        triples = set()
        for i in range(len(newNums)):
            valDict[newNums[i]] -= 1
            for j in range(len(newNums)):
                if i == j or newNums[i] > newNums[j]:
                    continue

                valDict[newNums[j]] -= 1
                val = -newNums[i] - newNums[j]
                if newNums[j] <= val and val in valDict and 0 < valDict[val]:
                    triples.add((newNums[i], newNums[j], val))
                valDict[newNums[j]] += 1
            valDict[newNums[i]] += 1

        return list(triples)
        #'''


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