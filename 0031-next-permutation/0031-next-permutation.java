class Solution {
    public void nextPermutation(int[] nums) {
        int i;

        for (i = nums.length - 1; i > 0 && nums[i - 1] >= nums[i]; i--);

        int j = i;

        if (0 < j) {
            for (; j < nums.length && nums[i - 1] < nums[j]; j++);
            int tmp = nums[i - 1];
            nums[i - 1] = nums[j - 1];
            nums[j - 1] = tmp;
        }

        for (j = i; j < (nums.length + i) / 2; j++) {
            int tmp = nums[j];
            nums[j] = nums[nums.length + i - j - 1];
            nums[nums.length + i - j - 1] = tmp;
        }
    }
}