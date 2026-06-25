class Solution {
    public boolean isEqual(String s, String p, int i, int j){
        return p.charAt(j)=='.'||p.charAt(j)==s.charAt(i);
    }

    public boolean rec(String s, String p, int i, int j, int dp[][]){
        if(i>=0&&j==-1){
            return false;
        }
        // i>=0&&j>=0, i==-1&&j==-1
        if(dp[i+1][j+1]!=0){
            return dp[i+1][j+1]==1?true:false;
        }
        if(i<0&&j>=0){
            if(p.charAt(j)=='*'){
                var r = rec(s, p, i, j-2, dp);
                dp[i+1][j+1]=r?1:2; 
                return r;
            }
            else{
                dp[i+1][j+1]=2;
                return false;
            }
        }
        boolean r;
        if(p.charAt(j)!='*'){
            r =isEqual(s, p, i, j);
            r = r&&rec(s, p, i-1, j-1, dp);
            dp[i+1][j+1]=r?1:2;
        }
        else{
            r =isEqual(s, p, i, j-1)&&rec(s, p, i-1, j, dp);
            r = r || rec(s, p, i, j-2, dp);
            dp[i+1][j+1]=r?1:2;
        }
        return r;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int dp[][] = new int[n+1][m+1];
        dp[0][0]=1;
        rec(s, p, n-1, m-1, dp);
        return dp[n][m]==1?true:false;
    }
}