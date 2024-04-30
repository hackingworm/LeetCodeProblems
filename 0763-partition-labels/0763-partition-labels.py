class Solution:
    def lastOccurrence(self, s: str, c: str) -> int:
        last = -1
        for i in range(len(s) - 1, -1, -1):
            if c == s[i]:
                last = i
                break
        #print(s, c, last)
        return last

    def partitionLabels(self, s: str) -> List[int]:
        lengths = []
        i = 0
        while (len(s) > i):
            start = i
            end = i
            while i <= end:
                end += self.lastOccurrence(s[end + 1:], s[i]) + 1
                i += 1
                #print(i, end)
            #print(s[start], s[i - 1], start, i)
            lengths.append(i - start)
        return lengths