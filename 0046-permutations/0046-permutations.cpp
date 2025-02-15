class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> rst;
        if (0 == nums.size()) {
            return rst;
        }

        rst.push_back({nums[0]});

        for (int i = 1; i < nums.size(); i++) {
            vector<vector<int>> nrst;
            for (int j = 0; j < rst.size(); j++) {
                for (int k = 0; k <= i; k++) {
                    nrst.push_back(rst[j]);
                    nrst[j * (i + 1) + k].insert(nrst[j * (i + 1) + k].begin() + i - k, nums[i]);
                }
            }

            /*
            for (int j = 0; j < i; j++) {
                nrst.push_back(rst[j]);
                nrst[i * i + j].insert(nrst[i * i + j].begin() + 0, nums[i]);
            }
            */

            rst = nrst;
        }
        
        return rst;
    }
};