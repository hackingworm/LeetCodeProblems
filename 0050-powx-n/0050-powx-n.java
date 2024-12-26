class Solution {
    public double myPow(double x, int n) {
        if (0 == x) {
            return 0;
        }

        if (1 == x || 0 == n) {
            return 1;
        }

        if (-1 == x) {
            return 0 == n % 2? 1: -1;
        }

        long ln = n;
        if (-1 < x && 1 > x) {
            x = 1/x;
            ln = -ln;
        }

        long pln = ln;
        if (0 > ln) {
            pln = -pln;
        }

        double result;
        if (1 < x) {
            result = x;
            long l = 1;
            while (pln >= 2 * l) {
                result *= result;
                l *= 2;
            }

            result *= myPow(x, (int)(pln - l));
        } else {
            result = 1;
            for (long l = 0; l < pln; l++) {
                result *= x;
            }
        }

        if (0 > ln) {
            result = 1/result;
        }

        return result;
    }
}