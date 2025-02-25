class Solution {
public:
    int maxArea(vector<int>& height) {
        int max = 0;
        int left = 0, right = height.size() - 1;
        while (left < right) {
            int water;
            if (height[left] <= height[right]) {
                int h = height[left];
                water = h * (right - left);
                do {
                    left++;
                } while (left < right && h >= height[left]);
            } else {
                int h = height[right];
                water = h * (right - left);
                do {
                    right--;
                } while (right > left && h >= height[right]);
            }

            if (max < water) {
                max = water;
            }
        }

        return max;
    }
};