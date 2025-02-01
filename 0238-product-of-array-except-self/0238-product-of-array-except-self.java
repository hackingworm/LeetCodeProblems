class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] subproducts = new int[nums.length];
        subproducts[0] = nums[0];
        for (int i = 1; nums.length - 1 > i; i++) {
            subproducts[i] = subproducts[i - 1] * nums[i];
        }
        subproducts[subproducts.length - 1] = nums[nums.length - 1];

        int[] answer = new int[nums.length];
        answer[answer.length - 1] = subproducts[subproducts.length - 2];
        for (int i = subproducts.length - 2; 0 < i; i--) {
            answer[i] = subproducts[i + 1] * subproducts[i - 1];
            subproducts[i] = subproducts[i + 1] * nums[i];
        }
        answer[0] = subproducts[1];
        return answer;        
    }
}