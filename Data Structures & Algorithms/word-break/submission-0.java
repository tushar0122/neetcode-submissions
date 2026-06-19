class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n];
        var k = new HashSet<String>(wordDict);
        int mx = 0;
        for(var i: k){
            mx = Math.max(mx, i.length());
        }
        for(int i=n-1;i>=0;i--){
            var r = false;
            var substr = "";
            for(int j=0;j<mx&&(i+j<n);j++){
                substr+= s.charAt(i+j);
                if(i+j+1<n){
                    r = r||(dp[i+j+1]&&k.contains(substr));
                }
                else{
                    r = r||k.contains(substr);
                }
            }
            dp[i]=r;
        }
        return dp[0];
    }
}