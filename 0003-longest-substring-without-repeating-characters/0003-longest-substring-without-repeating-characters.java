class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int length = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (-1 < s.substring(i, j).indexOf(s.charAt(j))) {
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