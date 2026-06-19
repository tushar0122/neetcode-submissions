class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        if(n==1){
            return nums[0]; 
        }
        else if(n==2){
            return Math.max(nums[0], nums[1]);
        }
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0], nums[1]);
        dp[2]=Math.max(dp[1], nums[2]+dp[0]);
        for(int i=3;i<n;i++){
            dp[i]=Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }
}
