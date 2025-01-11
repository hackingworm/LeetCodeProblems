class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> indices = new ArrayList<>();
        int highest = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (highest < heights[i]) {
                highest = heights[i];
                indices.add(i);
            }
        }

        int[] results = new int[indices.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = indices.get(results.length - i - 1);
        }

        return results;
    }
}