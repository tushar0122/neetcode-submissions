class Solution {
    public int coinChange(int[] coins, int amount) {
        int r = 0;
        int dp[] = new int[amount+1];
        int n = coins.length;
        for(int i=1;i<=amount;i++){
            int c = Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(i-coins[j]<0)continue;
                if(i-coins[j]==0){
                    c=1;
                    continue;
                }
                if(dp[i-coins[j]]==Integer.MAX_VALUE)continue;   
                c = Math.min(c, dp[i-coins[j]]+1);
            }
            dp[i]=c;
            System.out.println(i+" "+c);
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
