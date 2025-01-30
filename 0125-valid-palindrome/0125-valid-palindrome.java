class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^0-9A-Za-z]", "").toLowerCase();
        for (int begin = 0, end = s.length() - 1; begin < end; begin++, end--) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
        }

        return true;
    }
}