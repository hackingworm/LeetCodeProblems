class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        lines = []
        i = 0
        while i < len(words):
            width = 0
            j = 0
            while len(words) > i + j and maxWidth >= width + len(words[i + j]):
                width += len(words[i + j]) + 1
                j += 1

            toFill = maxWidth - width + 1
            if len(words) > i + j and 1 < j and 0 < toFill:
                q = toFill // (j - 1)
                r = toFill % (j - 1)
            else:
                q = 0
                r = 0

            line = words[i]
            for k in range(1, j):
                for l in range(q):
                    line += ' '
                
                if 0 < r:
                    line += ' '
                    r -= 1

                line += ' ' + words[i + k]

            if len(words) == i + j or 1 == j:
                for l in range(toFill):
                    line += ' '

            lines.append(line)
            i += j
            
        return lines