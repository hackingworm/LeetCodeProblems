class Solution {
    int getSmaller(vector<int>& nums1, int& idx1, vector<int>& nums2, int& idx2) {
        if (nums1.size() == idx1) {
            return nums2[idx2++];
        }

        if (nums2.size() == idx2) {
            return nums1[idx1++];
        }

        return nums1[idx1] > nums2[idx2]? nums2[idx2++]: nums1[idx1++];
    }

public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int count, idx1, idx2, val;
        for (idx1 = 0, idx2 = 0, count = 0;
            count < (nums1.size() + nums2.size() + 1) / 2; count++) {
            val = getSmaller(nums1, idx1, nums2, idx2);
        }

        return nums1.size() + nums2.size() == count * 2? 
            double(val + getSmaller(nums1, idx1, nums2, idx2)) / 2: val;
    }
};