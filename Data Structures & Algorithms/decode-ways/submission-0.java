class Solution {
    public int numDecodings(String s) {
        int curr = 0;
        int next = 1;
        int second_next = 1;
        int n = s.length();
        for(int i=n-1;i>=0;i--){
            char c = s.charAt(i);
            if(c=='0'){
                curr=0;
            }
            else{
                curr=next;
            }
            if((i+1)<n&&(c=='1'||(c=='2'&&s.charAt(i+1)<'7'))){
                curr+=second_next;
            }
            second_next = next;
            next = curr;
        }
        return curr;
    }
}
