class Solution:
    def longestPalindrome(self, s: str) -> str:
        def lenOfParlindrome(b: int, f: int):
            while 0 <= b and len(s) > f and s[b] == s[f]:
                b -= 1
                f += 1
            return f - b - 1

        longest = 0
        i = 0
        for i in range(0, len(s)):
            f = i + 1

            b = i
            length = lenOfParlindrome(b, f)
            if length > longest:
                longest = length
                begin = i - (length >> 1) + 1
                print("Stop1:", i, begin, length)

            b = i - 1
            length = lenOfParlindrome(b, f)
            if length > longest:
                longest = length
                begin = i - ((length - 1) >> 1)
                print("Stop2:", i, begin, length)

        return s[begin: begin + longest]
            
