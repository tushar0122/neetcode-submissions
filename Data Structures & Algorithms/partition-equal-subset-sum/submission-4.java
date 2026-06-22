class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sm = (Arrays.stream(nums).sum());
        if (sm % 2 != 0)
            return false;
        sm = sm / 2;
        boolean dp[] = new boolean[sm + 1];
        boolean newdp[] = new boolean[sm + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= sm; j++) {
                boolean r = false;
                r = (r || dp[j]);
                if (j - nums[i] >= 0) {
                    r = (r || dp[j - nums[i]]);
                }
                newdp[j] = r;
            }
            boolean temp[] = dp;
            dp = newdp;
            newdp = temp;
        }
        return dp[sm];
    }
}
