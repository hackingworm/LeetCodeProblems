class Solution:
    def canCross(self, stones: List[int]) -> bool:
        if 1 != stones[1]:
            return False
        
        self.stones = stones
        self.results = {}
        return self.canCrossWithStep(1, 1)
    
    def canCrossWithStep(self, index: int, step: int) -> bool:
        if len(self.stones) == index + 1:
            return True

        if self.results.get((index, step)) == False:
            return False

        forward = 1
        i = - 1
        while i < 2:
            if len(self.stones) == index + forward:
                break

            if self.stones[index + forward] < self.stones[index] + step + i:
                forward += 1
                #if len(self.stones) == index + forward:
                #    return False
                
                continue

            if self.stones[index + forward] == self.stones[index] + step + i:
                if self.canCrossWithStep(index + forward, step + i):
                    return True

                #self.results[(index + forward, step + i)] = False

                forward += 1
                #if len(self.stones) == index + forward:
                #    return False

            i += 1

        #print(index, step)
        self.results[(index, step)] = False
        return False