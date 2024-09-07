class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] counts = new int[26];
        for (int i = 0; i < counts.length; i++) {
            counts[i] = 0;
        }

        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] cloned = counts.clone();

            int j;
            for (j = i; j < i + s1.length(); j++) {
                if (0 == cloned[s2.charAt(j) - 'a']) {
                    break;
                }

                cloned[s2.charAt(j) - 'a']--;
            }

            // System.out.println(i + " " + j);
            if (i + s1.length() == j) {
                return true;
            }
        }

        return false;
    }
}