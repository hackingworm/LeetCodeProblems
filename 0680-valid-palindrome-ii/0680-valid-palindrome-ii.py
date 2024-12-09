class Solution:
    def validPalindrome(self, s: str) -> bool:
        begin = 0
        end = len(s) - 1
        while begin < end and s[begin] == s[end]:
            begin += 1
            end -= 1
        if begin >= end:
            return True

        savedBegin = begin
        savedEnd = end

        begin += 1
        while begin < end and s[begin] == s[end]:
            begin += 1
            end -= 1
        if begin >= end:
            return True

        begin = savedBegin
        end = savedEnd - 1
        while begin < end and s[begin] == s[end]:
            begin += 1
            end -= 1
        if begin >= end:
            return True

        return False