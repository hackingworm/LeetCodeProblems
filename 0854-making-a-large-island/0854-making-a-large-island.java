class Solution {
    int[][] grid;
    int len;

    int[][] nearby(int row, int col) {
        int[][] nearby = new int[4][2];

        nearby[0][0] = row;
        nearby[0][1] = col - 1;
        nearby[1][0] = row;
        nearby[1][1] = col + 1;
        nearby[2][0] = row - 1;
        nearby[2][1] = col;
        nearby[3][0] = row + 1;
        nearby[3][1] = col;

        return nearby;
    }

    int expand(int row, int col, int index) {
        grid[row][col] = index;

        int size = 1;
        for (int[] point: nearby(row, col)) {
            int r = point[0], c = point[1];
            if (0 <= r && len > r && 0 <= c && len > c && 1 == grid[r][c])
                size += expand(r, c, index);
        }

        return size;
    }

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        len = grid.length;

        List<Integer> isolates = new ArrayList();
        int index = 2;
        for (int row = 0; row < len; row++)
            for (int col = 0; col < len; col++)
                if (1 == grid[row][col]) 
                    isolates.add(expand(row, col, index++));

        int largest = 0;
        for (int size: isolates)
            if (largest < size)
                largest = size;

        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++)
                if (0 == grid[row][col]) {
                    Set<Integer> adjacent = new HashSet();
                    for (int[] point: nearby(row, col)) {
                        int r = point[0], c = point[1];
                        if (0 <= r && len > r && 0 <= c && len > c
                            && 1 < grid[r][c])
                            adjacent.add(grid[r][c]);
                    }

                    int size = 1;
                    for (int idx: adjacent)
                        size += isolates.get(idx - 2);

                    if (largest < size)
                        largest = size;
                }
        }

        return largest;
    }
}