class Solution {
    int[] accums;

    public Solution(int[] w) {
        accums = new int[w.length + 1];
        accums[0] = 0;
        for (int i = 0; i < accums.length - 1; i++) {
            accums[i + 1] = w[i];
            accums[i + 1] += accums[i];
        }
    }
    
    public int pickIndex() {
        int index = 0;
        double rnd = Math.random() * accums[accums.length - 1];
        int begin, end;
        for (begin = 0, end = accums.length - 1; begin < end;) {
            int middle = (begin + end - 1) / 2;

            if (accums[middle] < rnd && rnd <= accums[middle + 1]) {
                index = middle;
                break;
            }

            if (rnd <= accums[middle]) {
                end = middle;
            } else {
                begin = middle + 1;
            }
        }

        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */