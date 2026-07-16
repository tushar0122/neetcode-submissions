class Solution {

    public void rec(int [] candidates, int n, int target, int j, List<List<Integer>> r, List<Integer> temp){
        if(target == 0){
            r.add(new ArrayList<>(temp));
            return;
        }
        for(int i=j;i<n;i++){
            if(target>=candidates[i]){
                if(i>j&&candidates[i]==candidates[i-1]){
                    continue;
                }
                temp.add(candidates[i]);
                rec(candidates, n, target-candidates[i], i+1, r, temp);
                temp.remove(temp.size()-1);
            }
            else{
                break;
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        var temp = new ArrayList<Integer>();
        rec(candidates, n, target, 0, r, temp);
        return r;
    }
}
