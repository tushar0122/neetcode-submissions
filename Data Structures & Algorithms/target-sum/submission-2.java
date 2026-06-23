class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> dp = new HashMap();
        Map<Integer, Integer> newdp = new HashMap();
        dp.put(0, 1);
        for(int i=0;i<n;i++){
            newdp = new HashMap();
            for(var e: dp.entrySet()){
                int amount = e.getKey();
                int numOfWays = e.getValue();
                newdp.put(amount+nums[i], newdp.getOrDefault(
                    amount+nums[i], 0)+numOfWays);
                newdp.put(amount-nums[i], newdp.getOrDefault(
                    amount-nums[i], 0)+numOfWays);
            }
            dp = newdp;
        }
        return dp.getOrDefault(target, 0);
    }
}

// dp[i][amount]=dp[i-1][amount-num[i]]+dp[i-1][amount+nums[i]];
