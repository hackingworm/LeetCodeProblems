class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        int smallers = 0, largers = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (pivot > nums[i]) {
                smallers++;
            } else if (pivot < nums[i]) {
                largers++;
            }
        }

        vector<int> result(nums.size());
        int sIdx = 0, eIdx = smallers, lIdx = nums.size() - largers; 
        for (auto num : nums) {
            if (pivot > num) {
                result[sIdx++] = num;
            } else if (pivot < num) {
                result[lIdx++] = num;
            } else {
                result[eIdx++] = num;
            }
        }

        return result;
    }
};