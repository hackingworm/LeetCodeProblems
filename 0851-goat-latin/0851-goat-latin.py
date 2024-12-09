class Solution:
    def addSuffix(self, startingConsonant: str, wordCount: int, result: str) -> str:
        #print("Begin: ", result)
        if '' != startingConsonant:
            result += startingConsonant

        result += 'ma'

        for i in range(wordCount):
            result += 'a'
        #print("End: ", result)

        return result

    def toGoatLatin(self, sentence: str) -> str:
        vowels = 'aAeEiIoOuU'

        result = ''
        wordCount = 0
        wordInprocess = False
        startingConsonant = ''
        for i in range(len(sentence)):
            char = sentence[i]
            #print(char)

            if not wordInprocess:
                wordInprocess = True
                if char not in vowels:
                    startingConsonant = char
                    continue
                else:
                    startingConsonant = ''
        
            if ' ' == char:
                #print('space')
                wordCount += 1
                wordInprocess = False
                result = self.addSuffix(startingConsonant, wordCount, result)

            result += char

        return self.addSuffix(startingConsonant, wordCount + 1, result)
        #return result