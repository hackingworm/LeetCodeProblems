class Solution {
    double[] distr;

    public Solution(int[] w) {
        distr = new double[w.length];
        
        int sum = 0;
        for (int v : w) {
            sum += v;
        }

        int accum = 0;
        for (int i = 0; i < w.length; i++) {
            accum += w[i];
            distr[i] = (double)accum / sum;
        }
    }
    
    public int pickIndex() {
        double v = Math.random();

        int i;
        for (i = 0; i < distr.length && distr[i] < v; i++);

        return i;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */