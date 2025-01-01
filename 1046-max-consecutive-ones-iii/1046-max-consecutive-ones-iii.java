class Solution {
    public int longestOnes(int[] nums, int k) {
        int longest = 0;

        int start = 0;
        while (nums.length > start) {
            int leadingZeros;
            for (leadingZeros = 0; nums.length > start && 0 == nums[start]; start++, leadingZeros++);

            int length;
            for (length = 0; nums.length > start && 1 == nums[start]; length++, start++);
            int nextStart = start;

            int count = k;
            for (; nums.length > start; start++) {
                if (0 == nums[start]) {
                    if (0 == count) {
                        break;
                    }

                    count--;
                }

                length++;
            }

            length += leadingZeros < count? leadingZeros: count;
            if (longest < length) {
                longest = length;
            }

            start = nextStart;
        }

        return longest;
    }
}