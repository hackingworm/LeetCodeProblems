class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    /*
                    int[] pair = new int[2];
                    pair[0] = i;
                    pair[1] = j;
                    return pair;
                    */
                    int[] pair = {i, j};
                    return pair;
                }
            }
        }

        return null;
    }
}