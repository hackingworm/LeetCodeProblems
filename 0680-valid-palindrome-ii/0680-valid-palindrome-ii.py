class Solution:
    def validPalindrome(self, s: str) -> bool:
        begin = 0
        end = len(s) - 1
        while begin < end and s[begin] == s[end]:
            begin += 1
            end -= 1
        if begin >= end:
            return True

        # Something wrong, so it comes here.
        savedBegin = begin
        savedEnd = end

        # First, try to delete a character in the left side, then continue to check
        begin += 1
        while begin < end and s[begin] == s[end]:
            begin += 1
            end -= 1
        if begin >= end:
            return True

        # If it still fails, then delete a character in the right side this time

        begin = savedBegin
        end = savedEnd - 1
        while begin < end and s[begin] == s[end]:
            begin += 1
            end -= 1
        if begin >= end:
            return True

        return False