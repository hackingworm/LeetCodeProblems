class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        #triples = []
        triples = set()

        nums.sort()

        for i in range(len(nums) - 2):
            j = i + 1
            k = len(nums) - 1
            while j < k:
                if 0 > nums[i] + nums[j] + nums[k]:
                    j += 1
                elif 0 < nums[i] + nums[j] + nums[k]:
                    k -= 1
                else:
                    newList = [nums[i], nums[j], nums[k]]
                    #if newList not in triples:
                    #    triples.append(newList)
                    triples.add(tuple(newList))
                    j += 1
                    k -= 1

        #return triples
        return(list(triples))
