class Solution:
    def customSortString(self, order: str, s: str) -> str:
        # Construct a map, the key is the characters in "order", while the value is the character's occurance time in 's'
        freqs = {}
        for char in order:
            freqs[char] = 0

        result = '' # Initialize the result string
        # Check 's'
        for char in s:
            # If the charater is in 'order', the increase its occurance time
            if char in freqs:
                freqs[char] += 1
            # Else put it into the result string directly
            else:
                result += char

        # Put the characters in 'order' per its occurance time in 's'
        for char in order:
            for i in range(freqs[char]):
                result += char
                
        return result