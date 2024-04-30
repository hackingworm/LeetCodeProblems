class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        allowed = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}

        for r in range(0, 9):
            digits = set()
            for c in range(0, 9):
                num = board[r][c]
                if "." == num:
                    continue
                if num in allowed and num not in digits:
                    digits.add(num)
                else:
                    return False

        for c in range(0, 9):
            digits = set()
            for r in range(0, 9):
                num = board[r][c]
                if "." == num:
                    continue
                if num in allowed and num not in digits:
                    digits.add(num)
                else:
                    return False

        for i in range(0, 3):
            for j in range(0, 3):
                digits = set()
                for r in range(3 * i, 3 * (i + 1)):
                    for c in range(3 * j, 3 * (j + 1)):
                        num = board[r][c]
                        if "." == num:
                            continue
                        if num in allowed or num not in digits:
                            digits.add(num)
                        else:
                            return False

        return True 