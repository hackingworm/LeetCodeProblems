class Solution {
    class Heap {
        int[] nums;
        int size;

        void relocate(int i) {
            while (i < size / 2) {
                int target = i * 2 + 1;
                if (size > target + 1 && nums[target] < nums[target + 1]) {
                    target++;
                }

                if (nums[i] >= nums[target]) {
                    break;
                }

                int tmp = nums[i];
                nums[i] = nums[target];
                nums[target] = tmp;
                i = target;
            }
        }

        Heap(int[] nums) {
            this.nums = nums;
            size = nums.length;
            for (int i = size / 2 - 1; i >= 0; i--) {
                relocate(i);
            }
        }

        int getTop() {
            int top = nums[0];
            nums[0] = nums[--size];
            relocate(0);
            return top;
        }
    }

    public int findKthLargest(int[] nums, int k) {
        /*
        Arrays.sort(nums);
        return nums[nums.length - k];
        */

        Heap heap = new Heap(nums);
        for (int i = 0; i < k - 1; i++) {
            heap.getTop();
        }

        return heap.getTop();
    }
}