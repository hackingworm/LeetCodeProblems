class Solution:
    def customSortString(self, order: str, s: str) -> str:
        freqs = {}
        for char in order:
            freqs[char] = 0
        #print(freqs)

        result = ''
        for char in s:
            if char in freqs:
                freqs[char] += 1
            else:
                result += char

        #print(freqs)
        #print(result)

        for char in order:
            #print(char, freqs[char])
            for i in range(freqs[char]):
                result += char

        #print(result)
        return result