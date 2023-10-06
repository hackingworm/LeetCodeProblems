class Solution:
    def integerBreak(self, n: int) -> int:
        if 2 == n:
            return 1
        if 3 == n:
            return 2

        remainder = n % 3
        quotient = (n - remainder) / 3
        if 1 == remainder:
            quotient -= 1
            remainder = 4

        if 0 == remainder:
            return int(3 ** quotient)
        else:
            return int(3 ** quotient * remainder)