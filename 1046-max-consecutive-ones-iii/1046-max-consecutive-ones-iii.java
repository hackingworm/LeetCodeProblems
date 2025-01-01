class Solution {
    public int longestOnes(int[] nums, int k) {
        int longest = 0;
        int windowLength = 0;
        int begin = 0;

        for (int end = 0; end < nums.length; end++) {
            if (0 == nums[end]) {
                if (k > windowLength) {
                    windowLength++;
                } else {
                    if (longest < end - begin) {
                        longest = end - begin;
                    }

                    while (1 == nums[begin]) {
                        begin++;
                    }

                    begin++;
                }
            }
        }

        if (longest < nums.length - begin) {
            longest = nums.length - begin;
        }

        return longest;
    }
}