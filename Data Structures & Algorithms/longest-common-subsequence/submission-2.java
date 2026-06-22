class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[] = new int[n];
        for(int i=0;i<m;i++){
            int prev = 0;
            for(int j=0;j<n;j++){
                int tmp = dp[j];
                boolean r = text1.charAt(i)==text2.charAt(j);
                if(r){
                    dp[j]=1;
                    if(i>0&&j>0){
                        dp[j]+=prev;                        
                    }
                }
                else{
                    if(i>0&&j>0){
                        dp[j]=Math.max(dp[j-1], dp[j]);
                    }
                    else if(i==0&&j==0){
                        dp[j]=0;
                    }
                    else if(i==0){
                        dp[j]=dp[j-1];
                    }
                    else{
                    }
                }
                prev=tmp;
            }
        }   
        return dp[n-1];
    }
}
