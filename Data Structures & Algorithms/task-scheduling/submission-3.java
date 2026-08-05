class Solution {
    public int leastInterval(char[] tasks, int n) {
        int nt = tasks.length;
        if(n==0){
            return nt;
        }
        var mp = new HashMap<Character, Integer>();
        for(char c: tasks){
            if(mp.containsKey(c)){
                mp.put(c, mp.get(c)+1);
            }
            else{
                mp.put(c, 1);
            }
        }
        var pq = new PriorityQueue<Integer>((a, b)->{
            return b-a;
        });
        pq.addAll(mp.values());
        int r = 0;
        while(pq.size()>0){
            var l = new ArrayList<Integer>();
            int c = 0;
            while(pq.size()>0){
                var i = pq.poll();
                i--;
                c++;
                if(i>0){
                    l.add(i);
                }
                r++;
                if(c>n){
                    break;
                }
            }     
            if(c<=n&&l.size()>0){
                r+=n-c+1;
            }       
            if(l.size()>0){
                pq.addAll(l);
            }
        }
        return r;
    }
}
/*
n tasks 
c1, c2, c3, c4, .., cn

pq.size() < n
pq.size() >= n
min heap 

XXY 
X Y X
A 2 B 2 C 2 D 2 n=2
A B C

we have to take with more count first
*/

