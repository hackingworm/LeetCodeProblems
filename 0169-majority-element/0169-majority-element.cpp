class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int count = 0;
        int candidate;

        for (auto num : nums) {
            if (0 == count) {
                candidate = num;
            }

            count += candidate == num? 1: -1;
        }

        return candidate;
    }
};