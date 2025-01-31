class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> modified = new ArrayList();

        int i = 0;
        while (intervals.length > i
            && newInterval[0] > intervals[i][0]
            && newInterval[0] > intervals[i][1]) {
            modified.add(intervals[i]);

            i++;
        }

        if (intervals.length == i) {
            modified.add(newInterval);
            return modified.toArray(new int[modified.size()][2]);
        }

        if (newInterval[0] <= intervals[i][1]
            && newInterval[0] > intervals[i][0]) {
            newInterval[0] = intervals[i][0];
        }
        
        while (intervals.length > i && newInterval[1] >= intervals[i][0]) {
            i++;
        }

        if (0 < i && newInterval[1] < intervals[i - 1][1]) {
            newInterval[1] = intervals[i - 1][1];
        }

        modified.add(newInterval);

        while (intervals.length > i) {
            modified.add(intervals[i]);
            i++;
        }

        return modified.toArray(new int[modified.size()][2]);
    }
}