class Solution {
    public int subarraySum(int[] nums, int k) {
        int sums[] = new int[nums.length + 1]; 
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sums[0] = 0;
        for (int sum = 0, i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i + 1] = sum;
            if (sumMap.containsKey(sum)) {
                sumMap.replace(sum, sumMap.get(sum) + 1);
            } else {
                sumMap.put(sum, 1);
            }
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length + 1; j++) {
                if (k == sums[j] - sums[i]) {
                    count++;
                }
            }
            /*
            int key = k + sums[i];
            if (sumMap.containsKey(key)) {
                count += sumMap.get(key);
            }*/
        }

        return count;
    }
}