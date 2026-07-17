class Solution:
    # Move from "freshes" into "rottens"
    def rotting(self, freshes: Set(Tuple), rottens: Set(Tuple), i: int, j: int):
        if ((i, j)) in freshes:
            freshes.remove((i, j))
            rottens.add((i, j))

    def orangesRotting(self, grid: List[List[int]]) -> int:
        # Construct initial "freshes" set and "rottens" set
        freshes = set()
        rottens = set()
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if 1 == grid[i][j]:
                    freshes.add((i, j))
                elif 2 == grid[i][j]:
                    rottens.add((i, j))

        # if no fresh at all
        if not freshes:
            return 0

        steps = -1
        while rottens:
            # Initialize the set for those just rotten
            newRottens = set()
            for rotten in rottens:
                i = rotten[0]
                j = rotten[1]
                # Move adjacent fresh(es) into "newRottens"
                self.rotting(freshes, newRottens, i, j - 1)
                self.rotting(freshes, newRottens, i, j + 1)
                self.rotting(freshes, newRottens, i - 1, j)
                self.rotting(freshes, newRottens, i + 1, j)
        
            steps += 1

            # Set "rottens" to "newRottens" for the nexe round
            rottens = newRottens

        # If still any fresh remained
        if freshes:
            return -1

        return steps