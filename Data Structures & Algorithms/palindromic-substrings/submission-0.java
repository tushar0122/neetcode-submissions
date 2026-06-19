class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int r = 0;
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(i==j){
                    dp[i][j]=true;
                }
                else if(j-i==1){
                    dp[i][j]=s.charAt(i)==s.charAt(j);
                }
                else{
                    dp[i][j]=dp[i+1][j-1]&&s.charAt(i)==s.charAt(j);
                }
                if(dp[i][j]){
                    r++;
                }
            }
        }
        return r;
    }
}
