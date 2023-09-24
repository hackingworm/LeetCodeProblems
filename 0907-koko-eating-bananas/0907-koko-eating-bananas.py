class Solution:
    def totalRoundQuo(self, numbers: List[int], divisor: int) -> int:
        totalRoundQuo = 0
        for i in range(0, len(numbers)):
            totalRoundQuo += int((numbers[i] + divisor - 1) / divisor)

        return totalRoundQuo

    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        hpp = int(h / len(piles))
        minimum = int((min(piles) + hpp - 1) / hpp)
        maximum = int((max(piles) + hpp - 1) / hpp)
        
        while minimum < maximum:
            divisor = int((minimum + maximum) / 2)
            #print(divisor)
            totalHrs = self.totalRoundQuo(piles, divisor)
            if h < totalHrs:
                minimum = divisor + 1
                continue

            if h >= totalHrs:
                maximum = divisor - 1
                continue

        if h < self.totalRoundQuo(piles, minimum):
            minimum += 1
        return minimum