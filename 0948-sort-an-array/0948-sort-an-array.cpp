class Solution {
public:
    vector<int> merge(vector<int> nums1, vector<int> nums2) {
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
        return merge(mergeSort(nums, begin, mid), mergeSort(nums, mid, end));
    }

    vector<int> sortArray(vector<int>& nums) {
        return mergeSort(nums, 0, nums.size());
    }
};