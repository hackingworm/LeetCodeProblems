class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (1 == grid[0][0] || 1 == grid[grid.length -1][grid.length - 1]) {
            return -1;
        }

        if (1 == grid.length) {
            return 1;
        }

        int distance = 1;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        while (!queue.isEmpty()) {
            distance++;
            Queue<Pair<Integer, Integer>> newQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                Pair<Integer, Integer> coord = queue.poll();
                int row = coord.getKey(),
                    col = coord.getValue();
                for (int i = -1; i < 2; i++) {
                    if (0 <= row + i && grid.length > row + i) {
                        for (int j = -1; j < 2; j++) {
                            if (0 <= col + j && grid.length > col + j
                                && 0 == grid[row + i][col + j]) {
                                if (grid.length - 1 == row + i
                                    && grid.length - 1 == col + j) {
                                    return distance;
                                }

                                grid[row + i][col + j] = 1;
                                newQueue.add(new Pair(row + i, col + j));
                            }
                        }
                    }
                }
            }

            queue = newQueue;
        }

        return -1;
    }
}