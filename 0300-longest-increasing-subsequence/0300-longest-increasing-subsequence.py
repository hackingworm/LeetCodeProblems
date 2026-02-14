class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        longest = 1
        largest = nums[-1]
        length = [1] * len(nums)
        for i in range(len(nums) - 2, -1, -1):
            #print(i, nums[i])
            #length[i] = 1
            if largest <= nums[i]:
                largest = nums[i]
                continue

            #print(i, nums[i])
            l = 1
            for j in range(i + 1, len(nums)):
                #print(i, ':', nums[i], j, ':', nums[j])
                if nums[i] < nums[j] and l < length[j]:
                    l = length[j]
                    #print(i, nums[i], j, nums[j], l, longest)
                    if longest ==l:
                        break

            length[i] += l
            if longest < length[i]:
                longest = length[i] 

        return longest

        '''
        i = 0
        while len(nums) > i + 1 and nums[i] >= nums[i + 1]:
            i += 1

        if len(nums) == i:
            return 1

        #print(i, nums[i:])
        len1 = self.lengthOfLISStartFrom(nums[i], nums[i + 1:])

        j = i + 1
        while len(nums) > j and nums[i] <= nums[j]:
            j += 1
        #print(j, nums[j:])
        
        if len(nums) == j:
            return len1
        
        len2 = self.lengthOfLIS(nums[j:])
        if len2 > len1:
            return len2

        return len1
        '''

    '''
    def lengthOfLISStartFrom(self, num:int, nums: List[list]) -> int:
        if 0 == len(nums):
            return 1

        i = 0
        while len(nums) > i and num >= nums[i]:
            i += 1
        print(num, nums[0], nums[-1], i, end = ' ')
            
        if len(nums) == i:
            print('return', 1)
            return 1

        j = i + 1
        while len(nums) > j and nums[j - 1] < nums[j]:
            j += 1
        print(j, end = ' ')

        if len(nums) == j:
            print('return', j - i + 1)
            return j - i + 1

        if num < nums[j]:
            k = j - 1
            while i <= k and nums[j] < nums[k]:
                k -= 1
            print('k', k, end = ' ')
        
        print('Calculate len1')
        len1 = j - i + self.lengthOfLISStartFrom(nums[j - 1], nums[j:])
        print('len1', len1)
        
        if num >= nums[j] or 0 <= k and nums[k] == nums[j]:
            return len1

        print('Calculate len2')
        if k < i:
            len2 = self.lengthOfLISStartFrom(num, nums[j:])
        else:
            len2 = 1 + k - i + self.lengthOfLISStartFrom(nums[k], nums[j:])
        print('len2', len2)

        if len2 > len1:
            return len2

        return len1
    '''