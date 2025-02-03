class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triples = new ArrayList();
        
        Arrays.sort(nums);

        boolean[] choosen = new boolean[nums.length];

        for (int i = 0; i < nums.length - 2; i++) {
            if (choosen[i]) {
                break;
            }

            if (0 < i && nums[i - 1] == nums[i]) {
                continue;
            }

            HashMap<Integer, Integer> map = new HashMap();
            int j;
            for (j = i + 1; j < nums.length - 1 && !map.containsKey(nums[j]); j++) {
                if (choosen[j]) {
                    break;
                }

                if (i + 1 < j && nums[j - 1] == nums[j]) {
                    continue;
                }

                map.put(-nums[i] - nums[j], nums[j]);
            }

            for (int k = j; k < nums.length; k++) {
                if (j < k && nums[k - 1] == nums[k]) {
                    continue;
                }

                if (map.containsKey(nums[k])) {
                    choosen[k] = true;
                    List<Integer> triple = new ArrayList();
                    triple.add(nums[i]);
                    triple.add(map.get(nums[k]));
                    triple.add(nums[k]);
                    triples.add(triple);
                }
            }
        }

        return triples;
    }
}