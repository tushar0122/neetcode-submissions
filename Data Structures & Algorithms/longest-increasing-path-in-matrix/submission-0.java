class Solution {
    
    int[][] d = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};;

    public int getMax(int[][] matrix, int[][]dp, int i, int j, int m, int n){
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int mx = 1;
        for(int [] k : d){
            int ni = i+k[0];
            int nj = j+k[1];
            if(ni>=0&&ni<m&&nj>=0&&nj<n&&matrix[i][j]>matrix[ni][nj]){
                mx = Math.max(mx, 1+getMax(matrix, dp, ni, nj, m, n));
            }
        }
        dp[i][j]=mx;
        return mx;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        int mx = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mx = Math.max(mx, getMax(matrix, dp, i, j, m, n));
            }
        }
        return mx;
    }
}
