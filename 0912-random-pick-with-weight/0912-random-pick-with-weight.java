class Solution {
    int[] accums;

    public Solution(int[] w) {
        accums = w;
        for (int i = 0; i < accums.length - 1; i++) {
            accums[i + 1] += accums[i];
        }
    }
    
    public int pickIndex() {
        double rnd = Math.random() * accums[accums.length - 1];

        int i;
        for (i = 0; i < accums.length && accums[i] < rnd; i++);

        return i;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */