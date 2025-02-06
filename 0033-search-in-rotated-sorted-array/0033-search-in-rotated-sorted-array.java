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

        int top = -2;
        if (target < nums[mid]) {
            top = search(begin, mid);
            if (-1 < top) {
                return top;
            }
        }

        int bottom = -2;
        if (target > nums[mid]) {
            bottom = search(mid + 1, end);
            if (-1 < bottom) {
                return bottom;
            }
        }

        if (-2 == top) {
            top = search(begin, mid);
            if (-1 < top) {
                return top;
            }
        }

        if (-2 == bottom) {
            bottom = search(mid + 1, end);
            if (-1 < bottom) {
                return bottom;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        /*
        this.nums = nums;
        this.target = target;
        return search(0, nums.length);
        */
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }

        return -1;
    }
}