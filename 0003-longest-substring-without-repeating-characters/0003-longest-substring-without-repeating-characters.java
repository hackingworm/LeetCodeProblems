class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int length = 1;
            for (int j = i + 1; j < s.length(); j++) {
                int k;
                for (k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j))
                        break;
                }

                if (j > k) {
                    break;
                }

                length++;
            }

            if (maxLength < length) {
                maxLength = length;
            }
        }
        
        return maxLength;
    }
}