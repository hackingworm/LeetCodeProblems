class Solution {
    public int findPeakElement(int[] nums) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if ((0 == i || nums[i - 1] < nums[i])
                && (nums.length - 1 == i || nums[i] > nums[i + 1])) {
                break;
            }
        }

        return i;
    }
}