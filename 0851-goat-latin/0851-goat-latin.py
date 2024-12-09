class Solution:
    def addSuffix(self, startingConsonant: str, wordCount: int, result: str) -> str:
        # If the starting letter is consonant, it should be put at the end of the word
        if '' != startingConsonant:
            result += startingConsonant

        # Add 'ma'
        result += 'ma'

        # Append 'a' per its word index in the sentence
        for i in range(wordCount):
            result += 'a'

        return result

    def toGoatLatin(self, sentence: str) -> str:
        vowels = 'aAeEiIoOuU'

        result = ''
        wordCount = 0
        wordInprocess = False
        startingConsonant = ''
        for i in range(len(sentence)):
            char = sentence[i]

            # Begin to screen a new word
            if not wordInprocess:
                wordInprocess = True
                if char not in vowels:
                    startingConsonant = char
                    continue
                else:
                    startingConsonant = ''
        
            # Meet ' ', which means the end of a word
            if ' ' == char:
                wordCount += 1
                wordInprocess = False
                result = self.addSuffix(startingConsonant, wordCount, result)

            result += char

        # Add suffix for the last word
        return self.addSuffix(startingConsonant, wordCount + 1, result)