class Solution {
    public boolean isEqual(String s, String p, int i, int j){
        return p.charAt(j)=='.'||p.charAt(j)==s.charAt(i);
    }

    public boolean rec(String s, String p, int i, int j, int dp[][]){
        if(i==-1&&j==-1){
            return true;
        }
        if(i<0&&j>=0){
            if(p.charAt(j)=='*')return rec(s, p, i, j-2, dp);
            return false;
        }
        if(j<0||i<0){
            return false;
        }
        if(dp[i][j]!=0){
            return dp[i][j]==1?true:false;
        }
        boolean r;
        if(p.charAt(j)!='*'){
            r =isEqual(s, p, i, j);
            if(i>=0&&j>=0){
                r = r&&rec(s, p, i-1, j-1, dp);
            }
            dp[i][j]=r?1:2;
        }
        else{
            r =isEqual(s, p, i, j-1)&&rec(s, p, i-1, j, dp);
            if(j>=2){
                r = r || rec(s, p, i, j-2, dp);
            }
            dp[i][j]=r?1:2;
        }
        return r;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int dp[][] = new int[n][m];
        rec(s, p, n-1, m-1, dp);
        return dp[n-1][m-1]==1?true:false;
    }
}