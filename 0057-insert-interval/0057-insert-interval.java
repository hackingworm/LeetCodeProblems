class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> modified = new ArrayList();

        int i;
        for (i = 0; intervals.length > i
            && newInterval[0] > intervals[i][0]
            && newInterval[0] > intervals[i][1]; i++) {
            modified.add(intervals[i]);
        }

        if (intervals.length > i
            && newInterval[0] <= intervals[i][1]
            && newInterval[0] > intervals[i][0]) {
            newInterval[0] = intervals[i][0];
        }
        
        for (; intervals.length > i && newInterval[1] >= intervals[i][0]; i++);

        if (0 < i && newInterval[1] < intervals[i - 1][1]) {
            newInterval[1] = intervals[i - 1][1];
        }

        modified.add(newInterval);

        for (; intervals.length > i; i++) {
            modified.add(intervals[i]);
        }

        return modified.toArray(new int[modified.size()][2]);
    }
}