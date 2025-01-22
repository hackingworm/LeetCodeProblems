class Solution {
    int[] weights;
    int sum;

    public Solution(int[] w) {
        weights = w;
        sum = 0;
        for (int v : w) {
            sum += v;
        }
    }
    
    public int pickIndex() {
        double v = Math.random();

        int accum = 0;
        int i;
        for (i = 0; i < weights.length; i++) {
            accum += weights[i];
            if (sum * v <= accum) {
                break;
            }
        }

        return i;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */