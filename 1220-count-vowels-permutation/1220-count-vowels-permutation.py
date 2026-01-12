class Solution:
    def countVowelPermutation(self, n: int) -> int:
        na = 1
        ne = 1
        ni = 1
        no = 1
        nu = 1

        for i in range(1, n):
            nna = ne + ni + nu
            nne = na + ni
            nni = ne + no
            nno = ni
            nnu = ni + no
            na = nna
            ne = nne
            ni = nni
            no = nno
            nu = nnu

        return (na + ne + ni + no + nu) % (10 ** 9 + 7)