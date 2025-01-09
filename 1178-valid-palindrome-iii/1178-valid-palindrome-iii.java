class Solution {
    int memo[][];

    int isValidPalindrome(String s, int i, int j) {
        if (i == j) {
            return memo[i][j] = 0;
        }

        if (i + 1 == j) {
            return memo[i][j] = s.charAt(i) == s.charAt(j)? 0: 1;
        }

        if (-1 != memo[i][j]) {
            return memo[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            return memo[i][j] = isValidPalindrome(s, i + 1, j - 1);
        }

        return memo[i][j] = Math.min(isValidPalindrome(s, i, j - 1), isValidPalindrome(s, i + 1, j)) + 1; 
    }

    public boolean isValidPalindrome(String s, int k) {
        memo = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                memo[i][j] = -1;
            }
        }

        return k >= isValidPalindrome(s, 0, s.length() - 1);
    }
}