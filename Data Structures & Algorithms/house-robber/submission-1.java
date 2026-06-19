class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        if(n==1){
            return nums[0]; 
        }
        else if(n==2){
            return Math.max(nums[0], nums[1]);
        }
        dp[0]=nums[0];
        dp[1]=nums[1];
        dp[2]=nums[2]+dp[0];
        int mx = Math.max(dp[1], dp[2]);
        for(int i=3;i<n;i++){
            dp[i]=nums[i]+Math.max(dp[i-2], dp[i-3]);
            mx = Math.max(dp[i], mx);
        }
        return mx;
    }
}
