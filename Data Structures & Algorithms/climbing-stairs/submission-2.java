class Solution {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        int prev_2;
        int prev = 1;
        int curr = 2;
        prev_2=prev;
        prev=curr;
        for(int i=3;i<=n;i++){
            curr=prev+prev_2;
            prev_2=prev;
            prev=curr;
        }
        return curr;
    }
}
