class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        i = 0
        while i < len(strs[0]):
            unmatch = False
            for j in range(1, len(strs)):
                if i >= len(strs[j]) or strs[0][i] != strs[j][i]:
                    unmatch = True
                    break

            if unmatch:
                break

            i += 1

        return strs[0][0:i]

        