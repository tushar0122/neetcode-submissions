class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int[] res = new int[2];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                rec(s, i, j, dp, res);
            }
        }
        return s.substring(res[0], res[1]+1);
    }

    public boolean rec(String s, int i, int j, boolean dp[][], int[] res){
        if(i==j){
            dp[i][j]=true;
        }
        else if((j-i)==1){
            dp[i][j] = s.charAt(i)==s.charAt(j);
        }
        else{
            dp[i][j]=rec(s, i+1, j-1, dp, res)&&s.charAt(i)==s.charAt(j);
        }
        if(dp[i][j]&&(j-i)>(res[1]-res[0])){
            res[0]=i;
            res[1]=j;
        }
        return dp[i][j];
    }
}