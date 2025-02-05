class Solution {
    public void sortColors(int[] nums) {
        /*
        for (int i = 0, k = 0, j = nums.length - 1; k <= j;) {
            if (0 == nums[k]) {
                nums[k] = nums[i];
                nums[i] = 0;
                k++;
                i++;
                continue;
            }

            if (2 == nums[k]) {
                nums[k] = nums[j];
                nums[j] = 2;
                j--;
                continue;
            }

            k++;
        }
        */

        int[] counters = new int[3];
        for (int i = 0; i < nums.length; i++) {
            counters[nums[i]]++;
        }

        int i = 0;
        while (i < counters[0]) {
            nums[i++] = 0;
        }

        while (i < counters[0] + counters[1]) {
            nums[i++] = 1;
        }

        while (i < nums.length) {
            nums[i++] = 2;
        }
    }
}