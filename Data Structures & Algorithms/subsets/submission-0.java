class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        l.add(new ArrayList<Integer>());
        for(int i=0;i<n;i++){
            int s = l.size();
            for(int j=0;j<s;j++){
                var nl = new ArrayList<Integer>(l.get(j));
                nl.add(nums[i]);
                l.add(nl);
            }
        }
        return l;
    }
}

// dp[i]=dp[i-1]+{i}, {i-1}