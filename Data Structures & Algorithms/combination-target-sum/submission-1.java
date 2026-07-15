class Solution {
    void rec(int nums[], List<Integer> temp, int i, int target, Set<List<Integer>> r, int tsm){
        if(i==nums.length){
            if(tsm==target){
                r.add(new ArrayList<>(temp));
            }
            return;
        }
        rec(nums, temp, i+1, target, r, tsm);
        if(tsm+nums[i]>target){
            return;
        }
        temp.add(nums[i]);
        rec(nums, temp, i+1, target, r, tsm+nums[i]);
        rec(nums, temp, i, target, r, tsm+nums[i]);
        temp.remove(temp.size()-1);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> r = new HashSet<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        rec(nums, temp, 0, target, r, 0);
        return new ArrayList<>(r);
    }
}

// 4 3 5 
// include or we don't include
// 4 4 4 
// 4 
