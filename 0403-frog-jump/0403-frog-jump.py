class Solution:
    def canCross(self, stones: List[int]) -> bool:
        if 1 != stones[1]:
            return False
        
        self.stones = stones
        self.results = {}
        #print("Here", self.results)
        return self.canCrossWithStep(1, 1)
    
    def canCrossWithStep(self, index: int, step: int) -> bool:
        #print(index, step, self.stones[index])
        if len(self.stones) == index + 1:
            return True

        #print(index, step, self.results)
        if self.results.get((index, step)) == False:
            #print(index, step)
            return False

        forward = 1
        i = - 1
        while i < 2:
            if self.stones[index + forward] < self.stones[index] + step + i:
                forward += 1
                if len(self.stones) == index + forward:
                    return False
                
                continue

            if self.stones[index + forward] == self.stones[index] + step + i:
                if self.canCrossWithStep(index + forward, step + i):
                    return True

                #print("Before", self.results.get((index + forward, step + i)))
                self.results[(index + forward, step + i)] = False
                #print("After", self.results.get((index + forward, step + i)))

                forward += 1
                if len(self.stones) == index + forward:
                    return False

            i += 1

        #print(index, step)
        return False