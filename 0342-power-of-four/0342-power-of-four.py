class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        if 0 >= n:
            if -(2 << 31) == n:
                return True
            else:
                return False

        while 1 < n:
            m = n
            n >>= 2
            #print(m, n)
            if m > n << 2:
                return False

        return True