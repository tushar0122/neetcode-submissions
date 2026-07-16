class Solution {
    void rec(int nums[], List<Integer> temp, int i, int target, List<List<Integer>> r){
        if(target==0){
            r.add(new ArrayList<>(temp));
            return;
        }
        for(int j=i;j<nums.length;j++){
            if(target>=nums[j]){
                temp.add(nums[j]);
                rec(nums, temp, j, target-nums[j], r);
                temp.remove(temp.size()-1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        rec(nums, temp, 0, target, r);
        return r;
    }
}

// 4 3 5 
// include or we don't include
// 4 4 4 
// 4 
