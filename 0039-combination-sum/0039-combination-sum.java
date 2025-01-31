class Solution {
    int[] candidates;

    public List<List<Integer>> combinationSum(int length, int target) {
        List<List<Integer>> results = new ArrayList();
        if (target < candidates[0]) {
            return results;
        }

        for (int i = 0; i < length; i++) {
            int candidate = candidates[i];
            for (int j = target / candidate; j > 0; j--) {
                List<List<Integer>> subResults;
                int remain = target - j * candidate;
                if (0 == remain) {
                    subResults = new ArrayList();
                    subResults.add(new ArrayList());
                } else {
                    subResults = combinationSum(i, remain);
                }

                for (List<Integer> subResult : subResults) {
                    for (int k = 0; k < j; k++) {
                        subResult.add(candidate);
                    }

                    results.add(subResult);
                }
            }
        }

        return results;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        return combinationSum(candidates.length, target);
    }
}