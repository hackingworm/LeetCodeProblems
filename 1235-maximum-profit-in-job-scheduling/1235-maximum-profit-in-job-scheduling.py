class Solution:
    def jobScheduling(self, startTime: List[int], endTime: List[int], profit: List[int]) -> int:
        merged = [(0, 0, 0)] * len(startTime)
        for i in range(len(startTime)):
            merged[i] = (startTime[i], endTime[i], profit[i])
        #print(merged)
        self.profits = sorted(merged, key = lambda x: x[0])
        #print(self.profits)
        #return 0

        self.hit = 0
        self.maxProfitFrom = [0] * len(self.profits)
        maxProfit = self.jobSchedulingImpl(0)
        print("Hits", self.hit)
        return maxProfit

    def jobSchedulingImpl(self, start: int) -> int:
        if start == len(self.profits):
            return 0

        if start + 1 == len(self.profits):
            return self.profits[start][2]

        if 0 < self.maxProfitFrom[start]:
            self.hit += 1
            #print("hit", self.hit)
            return self.maxProfitFrom[start]

        begin = start + 1
        end = len(self.profits)
        while begin < end:
            middle = (begin + end) // 2

            if self.profits[start][1] <= self.profits[middle][0]:
                end = middle
            else:
                begin = middle + 1
        
        noOverlap = begin
        #print(noOverlap)
        #return 0

        maxProfit = self.profits[start][2] + self.jobSchedulingImpl(noOverlap)
        if 1 < noOverlap:
             maxProfit2 = self.jobSchedulingImpl(start + 1)
             if maxProfit < maxProfit2:
                maxProfit = maxProfit2

        self.maxProfitFrom[start] = maxProfit
        return maxProfit