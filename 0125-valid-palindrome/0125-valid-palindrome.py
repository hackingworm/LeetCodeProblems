class Solution:
    def isPalindrome(self, s: str) -> bool:
        if 0 == len(s):
            return False

        lows = s.lower()
        begin = 0
        end = len(lows) - 1
        while begin <= end:
            if not lows[begin].isalnum():
                begin += 1
                continue

            if not lows[end].isalnum():
                end -= 1
                continue

            if lows[begin] == lows[end]:
                begin += 1
                end -= 1
            else:
                return False
        
        return True