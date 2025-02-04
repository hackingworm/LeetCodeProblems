class Solution {
    public void sortColors(int[] nums) {
        for (int i = 0, k = 0, j = nums.length - 1; k <= j;) {
            if (0 == nums[k]) {
                if (0 == nums[i]) {
                    k++;
                } else {
                    nums[k] = nums[i];
                    nums[i] = 0;
                }

                i++;
                continue;
            }

            if (2 == nums[k]) {
                if (2 == nums[j]) {
                    // k++;
                } else {
                    nums[k] = nums[j];
                    nums[j] = 2;
                }

                j--;
                continue;
            }

            k++;
        }
    }
}