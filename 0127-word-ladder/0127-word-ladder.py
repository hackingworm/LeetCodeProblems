class Solution:
    def adjacent(self, wordA: str, wordB: str) -> bool:
        diffFound = False
        for i in range(len(wordA)):
            if wordA[i] != wordB[i]:
                if diffFound:
                    diffFound = False
                    break
                
                diffFound = True

        return diffFound

    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        currents = {beginWord}
        level = 1

        while currents and wordList:
            nexts = set()
            for current in currents:
                for word in wordList:
                    if self.adjacent(current, word):
                        if endWord == word:
                            return level + 1

                        nexts.add(word)

            for next in nexts:
                wordList.remove(next)

            currents = nexts
            level += 1

        return 0

        '''
        if beginWord == endWord:
            return 1

        min = 1 + len(wordList)
        for i in range(len(wordList)):
            if self.adjacent(beginWord, wordList[i]):
                #print(wordList[i], endWord, wordList[:i] + wordList[i + 1:])
                length = self.ladderLength(wordList[i], endWord, wordList[:i] + wordList[i + 1:])
                #print(length)
                if 0 < length and min > length:
                    min = length

        if 1 + len(wordList) == min:
            return 0

        return min + 1
        '''