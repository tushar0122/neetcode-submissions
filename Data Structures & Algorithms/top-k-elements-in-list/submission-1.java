class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var mp = new HashMap<Integer, Integer>();
        for(int i: nums){
            mp.put(i, mp.getOrDefault(i, 0)+1);
        }
        var tmp = new TreeMap<Integer, List<Integer>>(Collections.reverseOrder());
        for(var e: mp.entrySet()){
            var l = tmp.getOrDefault(e.getValue(), new ArrayList<Integer>());
            l.add(e.getKey());
            tmp.put(e.getValue(), l);
        }
        int r[] = new int[k];
        int c = 0;
        for(var e: tmp.entrySet()){
            var l = e.getValue();
            for(int i=0;i<l.size();i++){
                r[c++]=l.get(i);
                if(c==k){
                    break;
                }
            }
            if(c==k){
                break;
            }
        }
        return r;
    }
}
