class Solution {
    public boolean hasDuplicate(int[] nums) {
        var s = new HashSet<Integer>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(s.contains(nums[i])){
                return true;
            }
            s.add(nums[i]);
        }
        return false;
    }
}