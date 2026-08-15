class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var mp = new HashMap<Map<Character, Integer>, List<String>>();
        int n = strs.length;
        for(int i=0;i<n;i++){
            var has = new HashMap<Character, Integer>();
            for(int j=0;j<strs[i].length();j++){
                has.put(strs[i].charAt(j), has.getOrDefault(strs[i].charAt(j), 0)+1);
            }
            var l =  mp.getOrDefault(has, new ArrayList<String>());
            l.add(strs[i]);
            mp.put(has, l);
        }
        return new ArrayList<List<String>>(mp.values());
    }
}
