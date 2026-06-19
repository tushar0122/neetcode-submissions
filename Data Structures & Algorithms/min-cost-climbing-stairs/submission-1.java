class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev_2 = 0;
        int prev = 0;
        int curr = 0;
        for(int i=2;i<=n;i++){
            curr=Math.min(prev_2+cost[i-2], prev+cost[i-1]);
            prev_2=prev;
            prev=curr;
        }
        return curr;
    }
}
