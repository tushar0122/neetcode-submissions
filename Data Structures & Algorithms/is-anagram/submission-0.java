class Solution {
    public boolean isAnagram(String s, String t) {
        int c1[] = new int[128];
        for(char c: s.toCharArray()){
            c1[c-'0']++;
        }
        for(char c: t.toCharArray()){
            c1[c-'0']--;
        }
        for(int i=0;i<128;i++){
            if(c1[i]!=0){
                return false;
            }
        }
        return true;
    }
}
