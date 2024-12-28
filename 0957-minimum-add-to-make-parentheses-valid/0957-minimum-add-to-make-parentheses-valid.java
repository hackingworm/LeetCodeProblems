class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0,
            surplus = 0;
        for (int i = 0; i < s.length(); i++) {
            if (')' == s.charAt(i)) {
                if (0 < surplus) {
                    surplus--;
                } else {
                    count++;
                }
            } else {
                surplus++;
            }
        }

        return count + surplus;
    }
}