class Solution {

    public String encode(List<String> strs) {
        var s = new StringBuilder();
        for(var i: strs){
            s.append(i.length());
            s.append("|");
            s.append(i);
        }
        return s.toString();
    }

    public List<String> decode(String s) {
        var r = new ArrayList<String>();
        int n = s.length();
        int startIndex = 0;
        while(startIndex<n){
            var endIndex = s.indexOf("|", startIndex);
            var ls = s.substring(startIndex, endIndex);
            var l = Integer.valueOf(ls);
            var str = s.substring(endIndex+1, endIndex+1+l);
            r.add(str);
            startIndex = endIndex+1+l;
        }
        return r;
    }
}
