class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        var mp = new HashMap<Integer, Integer>();
        int k = 0;
        for(var i: nums){
            mp.put(i, k++);
        }
        for(int i=0;i<n;i++){
            int r = target-nums[i];
            int c = mp.getOrDefault(r, -1);
            if(nums[i]!=r&&c!=-1||(nums[i]==r&&c!=i)){
                return new int[]{i, c};
            }
        }        
        return new int[]{};
    }
}
