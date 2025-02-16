#define RESTRICT_ORDER

class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> rst;

        #if !defined(RESTRICT_ORDER)
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

            rst = nrst;
        }

        #else
        
        if (1 == nums.size()) {
            rst.push_back({nums[0]});
            return rst;
        }

        for (int i = 0; i < nums.size(); i++) {
            vector<int> subNums = nums;
            subNums.erase(subNums.begin() + i);
            vector<vector<int>> subRst = permute(subNums);
            for (int j = 0; j < subRst.size(); j++) {
                rst.push_back(subRst[j]);
                rst[i * subRst.size() + j].insert(rst[i * subRst.size() + j].begin() + 0, nums[i]);
            }
        }
        #endif
        
        return rst;
    }
};