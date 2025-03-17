class Solution {
public:
    vector<vector<int>> findMissingRanges(vector<int>& nums, int lower, int upper) {
        vector<vector<int>> ranges;
        for (int i = 0; i < nums.size(); i++) {
            if (lower < nums[i]) {
                ranges.push_back({lower, nums[i] - 1});
            }

            lower = nums[i] + 1;
        }
        
        if (lower <= upper) {
            ranges.push_back({lower, upper});
        }

        return ranges;
    }
};