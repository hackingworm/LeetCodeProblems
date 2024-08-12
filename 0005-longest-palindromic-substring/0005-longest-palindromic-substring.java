class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 1, maxLength = 1;

        for (int i = 0; i < s.length() - maxLength; i++) {
            for (int j = i + maxLength; j < s.length(); j++) {
                int backward, forward;
                for (backward = (i + j - 1) >> 1, forward = ((i + j ) >> 1) + 1;
                    forward <= j; backward--, forward++) {
                    if (s.charAt(backward) != s.charAt(forward)) {
                        break;
                    }
                }

                backward++;
                if (maxLength < forward - backward) {
                    maxLength = forward - backward;
                    start = backward;
                    end = forward;
                }
            }
        }

        return s.substring(start, end);
    }
}