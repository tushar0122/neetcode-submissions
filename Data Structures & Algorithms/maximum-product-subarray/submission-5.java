class Solution {
    public int maxProduct(int[] nums) {
        // dp[i]=Math.max(nums[i], nums[i]*dp[i-1]);
        int n = nums.length;
        int curr = 1;
        int curr_min = 1;
        int prev = 1;
        int prev_min = 1;
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            curr = Math.max(Math.max(nums[i], nums[i]*prev), nums[i]*prev_min);
            curr_min = Math.min(Math.min(nums[i], nums[i]*prev_min), nums[i]*prev);
            prev = curr;
            prev_min = curr_min;
            mx = Math.max(mx, curr);
        } 
        return mx;
    }
}
