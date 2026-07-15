class Solution {
    void rec(int nums[], List<Integer> temp, int i, int target, List<List<Integer>> r, int tsm){
        if(tsm==target){
            r.add(new ArrayList<>(temp));
            return;
        }
        if(i==nums.length || tsm >target){
            return;
        }
        rec(nums, temp, i+1, target, r, tsm);
        temp.add(nums[i]);
        rec(nums, temp, i, target, r, tsm+nums[i]);
        temp.remove(temp.size()-1);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        rec(nums, temp, 0, target, r, 0);
        return r;
    }
}

// 4 3 5 
// include or we don't include
// 4 4 4 
// 4 
