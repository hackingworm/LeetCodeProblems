enum Algorithm {
    MergeSort,
    HeapSort,
    QuickSort
};

class Solution {
    Algorithm algo;
public:
    vector<int> merge(vector<int>& nums1, vector<int>& nums2) {
        vector<int> nums(nums1.size() + nums2.size());
        int i, j, k;
        for (i = 0, j = 0, k = 0; nums1.size() > i && nums2.size() > j;) {
            if (nums2[j] < nums1[i]) {
                nums[k++] = nums2[j++];
            } else {
                nums[k++] = nums1[i++];
            }
        }

        for (; nums1.size() > i; i++, k++) {
            nums[k] = nums1[i];
        }

        for (; nums2.size() > j; j++, k++) {
            nums[k] = nums2[j];
        }

        return nums;
    }

    vector<int> mergeSort(vector<int>& nums, int begin, int end) {
        if (begin + 1 == end) {
            return {nums[begin]};
        }

        int mid = (begin + end) / 2;
        vector<int> nums1 = mergeSort(nums, begin, mid);
        vector<int> nums2 = mergeSort(nums, mid, end);
        return merge(nums1, nums2);
    }

    void heapify(vector<int>& nums, int idx, int end) {
        while (end / 2 > idx) {
            int can = 2 * idx + 1;
            if (end > can + 1 && nums[can] < nums[can + 1]) {
                can++;
            }

            if (nums[idx] >= nums[can]) {
                break;
            }
            
            int tmp = nums[idx];
            nums[idx] = nums[can];
            nums[can] = tmp;
            idx = can;
        }
    }

    void buildHeap(vector<int>& nums) {
        for (int i = (nums.size() - 1) / 2; i >= 0; i--) {
            heapify(nums, i, nums.size());
        }
    }

    vector<int> heapSort(vector<int>& nums) {
        buildHeap(nums);
        for (int i = nums.size() - 1; i > 0; i--) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            heapify(nums, 0, i);
        }

        return nums;
    }

    vector<int> sortArray(vector<int>& nums) {
        algo = HeapSort;
        if (MergeSort == algo) {
            return mergeSort(nums, 0, nums.size());
        } else if (HeapSort == algo) {
            return heapSort(nums);
        } else if (QuickSort == algo) {}

        return {};
    }
};