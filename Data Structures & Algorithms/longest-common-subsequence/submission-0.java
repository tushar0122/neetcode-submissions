class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean r = text1.charAt(i)==text2.charAt(j);
                if(r){
                    dp[i][j]=1;
                    if(i>0&&j>0){
                        dp[i][j]+=dp[i-1][j-1];                        
                    }
                }
                else{
                    if(i>0&&j>0){
                        dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
                    }
                    else if(i==0&&j==0){
                        dp[i][j]=0;
                    }
                    else if(i==0){
                        dp[i][j]=dp[i][j-1];
                    }
                    else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
        }   
        return dp[m-1][n-1];
    }
}
