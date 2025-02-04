class Solution {
    public void sortColors(int[] nums) {
        for (int i = 0, k = 0, j = nums.length - 1; k <= j;) {
            if (0 == nums[k]) {
                if (0 != nums[i]) {
                    nums[k] = nums[i];
                    nums[i] = 0;
                } else {
                    k++;
                }

                i++;
                continue;
            }

            if (2 == nums[k]) {
                if (2 != nums[j]) {
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