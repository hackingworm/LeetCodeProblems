class Solution {
    private void rotting(Set<Integer> freshes, Set<Integer> rottens, int index) {
        if (freshes.contains(index)) {
            freshes.remove(index);
            rottens.add(index);
        }
    }

    public int orangesRotting(int[][] grid) {
        Set<Integer> freshes = new HashSet<>();
        Set<Integer> rottens = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int index = i * grid[i].length + j;
                if (1 == grid[i][j]) {
                    freshes.add(index);
                } else if (2 == grid[i][j]) {
                    rottens.add(index);
                }
            }
        }

        System.out.println(freshes);
        System.out.println(rottens);

        if (freshes.isEmpty()) {
            return 0;
        } 

        int steps = -1;
        while (!rottens.isEmpty()) {
            Set<Integer> newRottens = new HashSet<>();
            for (int index : rottens) {
                int i = index / grid[0].length, j = index % grid[0].length;

                if (0 < j) {
                    rotting(freshes, newRottens, index - 1);
                }

                if (grid[0].length - 1 > j) {
                    rotting(freshes, newRottens, index + 1);
                }

                if (0 < i) {
                    rotting(freshes, newRottens, index - grid[0].length);
                }

                if (grid.length - 1 > i) {
                    rotting(freshes, newRottens, index + grid[0].length);
                }
            }

            steps++;
            rottens = newRottens;
        }

        if (freshes.isEmpty()) {
            return steps;
        }

        return -1;
    }
}