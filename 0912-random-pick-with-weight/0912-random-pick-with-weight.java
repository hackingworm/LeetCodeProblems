class Solution {
    int[] accums;

    public Solution(int[] w) {
        accums = new int[w.length + 1];
        accums[0] = 0;
        for (int i = 0; i < accums.length - 1; i++) {
            accums[i + 1] = w[i];
            accums[i + 1] += accums[i];
            // System.out.print(accums[i] + " ");
        }
        // System.out.println(accums[accums.length - 1]);
    }
    
    public int pickIndex() {
        double rnd = Math.random() * accums[accums.length - 1];
        /*
        if (3 <= accums.length && accums[1] < rnd && rnd <= accums[2]) {
            System.out.println(rnd);
        }
        */

        /*
        int i;
        for (i = 0; i < accums.length && accums[i] < rnd; i++);

        return i;
        */

        int begin, end;
        for (begin = 0, end = accums.length - 1; begin < end;) {
            int middle = (begin + end + 1) / 2;
            /*
            if (3 <= accums.length && accums[1] < rnd && rnd <= accums[2]) {
                System.out.println(begin + " " + end + " " + accums[middle]);
            }
            */

            if (accums[middle - 1] < rnd && rnd <= accums[middle]) {
                return middle - 1;
            }

            if (rnd <= accums[middle - 1]) {
                end = middle - 1;
            } else {
                begin = middle;
            }
        }

        /*
        if (3 <= accums.length && accums[1] < rnd && rnd <= accums[2]) {
            System.out.println(begin);
        }
        */

        return 0;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */