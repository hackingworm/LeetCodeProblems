class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        for (int sum = 0, i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumMap.containsKey(sum - k)) {
                count += sumMap.get(sum -k);
            }

            if (sumMap.containsKey(sum)) {
                sumMap.replace(sum, sumMap.get(sum) + 1);
            } else {
                sumMap.put(sum, 1);
            }
            
            /*
            if (sumMap.containsKey(sum - k)) {
                count += sumMap.get(sum - k);
            }
            */
        }

        return count;
    }
}