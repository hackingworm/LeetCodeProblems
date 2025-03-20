class Solution {
    bool allZero(vector<int>& nums, vector<int>& diff) {
        for (int ps = 0, i = 0; i < nums.size(); i++) {
            ps += diff[i];
            if (ps < nums[i]) {
                return false;
            }
        }

        return true;
    }

public:
    int minZeroArray(vector<int>& nums, vector<vector<int>>& queries) {
        vector<int> diff(nums.size() + 1, 0);
        int min = -1, current = 0, left = 0, right = queries.size();
        while (left <= right) {
            int middle = (left + right) / 2;
            if (current < middle) {
                for (int i = current; i < middle; i++) {
                    diff[queries[i][0]] += queries[i][2];
                    diff[queries[i][1] + 1] -= queries[i][2];
                }
            } else {
                for (int i = middle; i < current; i++) {
                    diff[queries[i][0]] -= queries[i][2];
                    diff[queries[i][1] + 1] += queries[i][2];
                }
            }

            current = middle;
            if (allZero(nums, diff)) {
                min = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return min;
    }
};