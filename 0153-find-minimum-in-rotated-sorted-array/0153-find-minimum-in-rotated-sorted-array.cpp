class Solution {
public:
    int findMin(vector<int>& nums) {
        int b = 0, e = nums.size();

        if (nums[0] < nums[e - 1]) {
            return nums[0];
        }
        
        while (b < e) {
            int m = (b + e) / 2;
            if (nums[0] < nums[m]) {
                b = m + 1;
            } else {
                if (1 == m) {
                    return nums[m];
                }
                
                e = m;
            }
        }

        return nums[b];
    }
};