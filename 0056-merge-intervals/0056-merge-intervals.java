class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList();
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (prev[1] >= cur[0]) {
                if (cur[1] > prev[1]) {
                    prev[1] = cur[1];
                }
            } else {
                merged.add(prev);
                prev = cur;
            }
        }
        merged.add(prev);

        return merged.toArray(new int[merged.size()][]);
    }
}