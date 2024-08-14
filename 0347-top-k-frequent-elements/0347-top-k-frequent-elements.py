class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqs = {}
        for num in nums:
            if freqs.get(num) == None:
                freqs[num] = 1
            else:
                freqs[num] += 1
        #print(freqs)
        sortedFreqs = dict(sorted(freqs.items(), key = lambda item: item[1], reverse = True))
        #print(sortedFreqs)
        results = [key for key, value in sortedFreqs.items()]
        #print(results)
        return results[:k]
