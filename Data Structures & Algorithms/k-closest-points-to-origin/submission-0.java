class Solution {
    public int[][] kClosest(int[][] points, int k) {
        var pq = new PriorityQueue<int[]>((a, b)->{
            var v1 = a[0]*a[0] + a[1]*a[1];
            var v2 = b[0]*b[0] + b[1]*b[1];
            return v2-v1;
        });
        for(int []i: points){
            pq.add(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        var r = new int[k][2];
        for(int i=0;i<k;i++){
            r[i]=pq.poll();
        }
        return r;
    }
}
