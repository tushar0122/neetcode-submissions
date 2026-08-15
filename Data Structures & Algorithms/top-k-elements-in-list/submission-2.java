class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var mp = new HashMap<Integer, Integer>();
        for(int i: nums){
            mp.put(i, mp.getOrDefault(i, 0)+1);
        }
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for(var e: mp.entrySet()){
            freq[e.getValue()].add(e.getKey());
        }
        int r[] = new int[k];
        int c = 0;
        for (int i = freq.length - 1; i > 0 && c < k; i--) {
            for (int n : freq[i]) {
                r[c++] = n;
                if (c == k) {
                    return r;
                }
            }
        }
        return r;
    }
}
