class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> dp[] = new HashMap[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=new HashMap<>();
        }
        dp[0].put(0, 1);
        for(int i=0;i<n;i++){
            for(var e: dp[i].entrySet()){
                int amount = e.getKey();
                int numOfWays = e.getValue();
                dp[i+1].put(amount+nums[i], dp[i+1].getOrDefault(
                    amount+nums[i], 0)+numOfWays);
                dp[i+1].put(amount-nums[i], dp[i+1].getOrDefault(
                    amount-nums[i], 0)+numOfWays);
            }
        }
        return dp[n].getOrDefault(target, 0);
    }
}

// dp[i][amount]=dp[i-1][amount-num[i]]+dp[i-1][amount+nums[i]];
