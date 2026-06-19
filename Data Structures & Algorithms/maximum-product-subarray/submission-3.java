class Solution {
    public int maxProduct(int[] nums) {
        // dp[i]=Math.max(nums[i], nums[i]*dp[i-1]);
        int n = nums.length;
        int curr = 1;
        int curr_neg = 1;
        int prev = 1;
        int prev_neg = 1;
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            curr = Math.max(Math.max(nums[i], nums[i]*prev), nums[i]*curr_neg);
            curr_neg = Math.min(Math.min(nums[i], nums[i]*prev_neg), nums[i]*prev);
            prev = curr;
            prev_neg = curr_neg;
            mx = Math.max(mx, curr);
        } 
        return mx;
    }
}
