class Solution {
    public int longestOnes(int[] nums, int k) {
        int longest = 0;

        for (int start = 0; start < nums.length; start++) {
            int length = 0;
            int count = 0;
            for (int index = start; index < nums.length; index++) {
                if (0 == nums[index]) {
                    if (k == count) {
                        break;
                    }

                    count++;
                }

                length++;
            }

            if (longest < length) {
                longest = length;
            }

        }

        return longest;
        
    }
}