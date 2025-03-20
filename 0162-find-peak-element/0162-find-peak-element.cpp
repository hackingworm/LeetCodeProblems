#define BRUTE 0

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        #if BRUTE
        int i;
        for (i = 0; i < nums.size(); i++) {
            if ((0 == i || nums[i - 1] < nums[i])
                && (nums.size() == i + 1 || nums[i] > nums[i + 1])) {
                break;
            }
        }

        return i;
        #else
        int left = 0, right = nums.size();
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums.size() > middle + 1 && nums[middle] < nums[middle + 1]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return right;
        #endif        
    }
};