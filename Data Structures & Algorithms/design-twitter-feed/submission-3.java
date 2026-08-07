class Twitter {
    Map<Integer, HashSet<Integer>> followers_mp;
    Map<Integer, ArrayList<int[]>> tweets_mp;
    int t = 0;
    public Twitter() {
        followers_mp = new HashMap<Integer, HashSet<Integer>>();
        tweets_mp = new HashMap<Integer, ArrayList<int[]>>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweets_mp.containsKey(userId)){
            tweets_mp.put(userId, new ArrayList<int[]>());
        }
        var q = tweets_mp.get(userId);
        q.add(new int[]{t++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!tweets_mp.containsKey(userId)){
            tweets_mp.put(userId, new ArrayList<int[]>());
        }
        var lq = new ArrayList<ArrayList<int[]>>();
        var q = tweets_mp.get(userId);
        lq.add(q);
        for(var i: followers_mp.getOrDefault(userId, new HashSet<Integer>())){
            if(tweets_mp.containsKey(i)){
                lq.add(tweets_mp.get(i));
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b)->{
            return b[0]-a[0];
        });
        for(int i=0;i<lq.size();i++){
            var l = lq.get(i);
            var s = l.size();
            if(s>0){
                pq.add(new int[]{l.get(s-1)[0], i, s-1});
            }
        }
        var r = new ArrayList<Integer>();
        while(pq.size()>0&&r.size()<10){
            var tp = pq.poll();
            var l = lq.get(tp[1]);
            var in = tp[2];
            r.add(l.get(tp[2])[1]);
            if(in-1>=0){
                pq.add(new int[]{l.get(in-1)[0], tp[1], in-1});
            }
        }
        return r;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId)return;
        if(!followers_mp.containsKey(followerId)){
            followers_mp.put(followerId, new HashSet<Integer>());
        }
        followers_mp.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!followers_mp.containsKey(followerId)){
            followers_mp.put(followerId, new HashSet<Integer>());
        }
        followers_mp.get(followerId).remove(followeeId);
    }
}
