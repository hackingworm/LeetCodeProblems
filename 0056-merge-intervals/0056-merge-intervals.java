class Solution {
    public int[][] merge(int[][] intervals) {
        /*
        for (int i = 0; i < intervals.length - 1; i++) {
            int min = i;
            for (int j = i; j < intervals.length; j++) {
                if (intervals[min][0] > intervals[j][0]) {
                    min = j;
                }
            }

            if (min != i) {
                int[] tmp = intervals[i];
                intervals[i] = intervals[min];
                intervals[min] = tmp;
            }
        }
        */

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

        int[][] result = new int[merged.size()][2];
        return merged.toArray(result);
    }
}