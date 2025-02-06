class Solution {
    int[] nums;
    int target;

    int search(int begin, int end) {
        if (begin == end) {
            return -1;
        }

        int mid = (begin + end) / 2;
        if (target == nums[mid]) {
            return mid;
        }

        int res = search(begin, mid);
        if (-1 < res) {
            return res;
        }

        return search(mid + 1, end);
    }

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return search(0, nums.length);
    }
}