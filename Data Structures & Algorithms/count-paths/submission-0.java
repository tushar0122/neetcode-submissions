class Solution {
    public int uniquePaths(int m, int n) {
    int dp[] = new int[n];
    int prev = 1;
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(i==0&&j==0){
                dp[j]=1;
            }
            else if(i==0){
                dp[j]=prev;
            }
            else if(j==0){
                dp[j]=1;
            }
            else{
                dp[j]=prev+dp[j];
            }
            prev = dp[j];
        }
    }
    return dp[n-1];

    }
}
