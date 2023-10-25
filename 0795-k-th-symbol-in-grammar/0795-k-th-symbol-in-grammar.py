class Solution:
    def kthGrammar(self, n: int, k: int) -> int:
        accu = 0
        k -= 1
        while 0 < k:
            accu += k % 2
            k >>= 1

        return accu % 2