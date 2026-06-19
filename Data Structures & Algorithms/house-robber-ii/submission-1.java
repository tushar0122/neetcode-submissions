class Solution {
    public int findMax(int[] nums, int s, int e){
        int n = e-s+1;
        int a = nums[s];
        if(n==1){
            return a;
        }
        int b = Math.max(nums[s], nums[s+1]);
        if(n==2){
            return b;
        }
        int c = Math.max(b, nums[s+2]+a);
        a = b;
        b = c;
        for(int i=s+3;i<=e;i++){
            c = Math.max(b, nums[i]+a);
            a = b;
            b = c;
        }
        return c;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0], nums[1]);
        }
        int r = Math.max(findMax(nums, 0, n-2), findMax(nums, 1, n-1));
        return r;
    }
}