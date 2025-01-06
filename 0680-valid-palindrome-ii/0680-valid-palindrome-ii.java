class Solution {
    boolean validPalindromeImpl(String s, boolean removed) {
        int i = 0, j = s.length() - 1;
        for (; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                if (removed) {
                    return false;
                }

                if (s.charAt(i) == s.charAt(j - 1)) {
                    if (validPalindromeImpl(s.substring(i, j), true)) {
                        return true;
                    }
                }
                
                if (s.charAt(i + 1) == s.charAt(j)) {
                    if (validPalindromeImpl(s.substring(i + 1, j + 1), true)) {
                        return true;
                    }
                }

                return false;
            }
        }

        return true;
    }

    public boolean validPalindrome(String s) {
        return validPalindromeImpl(s, false);
    }
}