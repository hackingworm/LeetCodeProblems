class Solution:
    n2l = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}

    def letterCombinations(self, digits: str) -> List[str]:
        res = []
        letters = self.n2l.get(digits[0])

        if 1 == len(digits):
            for l in letters:
                res.append(l)
        
            return res

        subres = self.letterCombinations(digits[1:])
        for l in letters:
            for st in subres:
                res.append(l + st)

        return res
        