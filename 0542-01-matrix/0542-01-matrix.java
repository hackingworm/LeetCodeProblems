class Solution {
    int neighborNum(int num, int[][]mat, int i, int j) {
        if (   0 < j && num == mat[i][j - 1] || mat[i].length - 1 > j && num == mat[i][j + 1]
            || 0 < i && num == mat[i - 1][j] || mat.length - 1 > i && num == mat[i + 1][j]) {
            return num + 1;
        }

        return num + 2;
    } 

    public int[][] updateMatrix(int[][] mat) {
        boolean resolved = false;
        int num = 0;
        while (!resolved) {
            resolved = true;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    if (num + 1 == mat[i][j]) {
                        mat[i][j] = neighborNum(num, mat, i, j);
                        if (num + 2 == mat[i][j]) {
                            resolved = false;
                        }
                    }
                }
            }

            num++;
        }

        return mat;
    }
}