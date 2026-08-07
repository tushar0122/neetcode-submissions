class MedianFinder {
    int s = 0;
    PriorityQueue<Integer> mx = new PriorityQueue<Integer>((a, b)->{
        return b-a;
    });
    PriorityQueue<Integer> mn = new PriorityQueue<Integer>();
    public MedianFinder() {

    }
    
    public void addNum(int num) {
        mx.add(num);
        if(mn.size()>0){
            if(mx.peek()>mn.peek()){
                var t = mn.poll();
                mn.add(mx.poll());
                mx.add(t);
            }
        }
        if(mx.size()-mn.size()>1){
            mn.add(mx.poll());
        }
        s++;
    }
    
    public double findMedian() {
        if(s%2==0&&s>0){
            return (mx.peek()+mn.peek())/2.0;
        }
        else{
            return mx.peek();
        }
    }
}
