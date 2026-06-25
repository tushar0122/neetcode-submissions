class Solution {
  //  max of it = dp[l][r]=dp[l][i-1]+dp[i+1][r];
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int newNums[] = new int[n+2];
        for(int i=0;i<n;i++){
            newNums[i+1]=nums[i];
        }
        newNums[0]=newNums[n+1]=1;
        int dp[][] = new int[n+2][n+2];
        for(int i=n;i>=1;i--){
            for(int j=i;j<=n;j++){
                for(int k=i;k<=j;k++){
                    int coins = newNums[i-1]*newNums[k]*newNums[j+1];
                    coins+=dp[i][k-1]+dp[k+1][j];
                    dp[i][j]=Math.max(dp[i][j], coins);
                }
            }
        }
        return dp[1][n];
    }
}
