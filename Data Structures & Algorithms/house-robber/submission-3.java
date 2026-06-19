class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int curr = 0;
        int prev = 0;
        int prev_2 = 0;
        if(n==1){
            return nums[0]; 
        }
        else if(n==2){
            return Math.max(nums[0], nums[1]);
        }
        prev_2=nums[0];
        prev=Math.max(prev_2, nums[1]);
        curr=Math.max(prev, nums[2]+prev_2);
        prev_2=prev;
        prev=curr;
        for(int i=3;i<n;i++){
            curr=Math.max(prev, nums[i]+prev_2);
            prev_2=prev;
            prev=curr;
        }
        return curr;
    }
}
