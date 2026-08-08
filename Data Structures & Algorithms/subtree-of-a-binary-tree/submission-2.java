/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  

    public void rec(TreeNode root, StringBuilder r){
        if(root==null){
            r.append("|#");
        }
        else{
            r.append("|"+root.val);
            rec(root.left, r);
            rec(root.right, r);
        }
    }

    public String serialize(TreeNode root) {
        StringBuilder r = new StringBuilder();
        rec(root, r);
        return r.toString();
    }

    public void computeLPS(int[] lps, String p){
        int i = 1;
        int l = 0;
        lps[0]=0;
        int n = p.length();
        while(i<n){
            if(p.charAt(i)==p.charAt(l)){
                l++;
                lps[i]=l;
                i++;
            }
            else{
                if(l==0){
                    lps[i]=0;
                    i++;
                }
                else{
                    l = lps[l-1];
                }
            }
        }
    }

    public boolean kmp(String t, String p) {
        int []lps = new int[p.length()];
        computeLPS(lps, p);
        int i=0;
        int j=0;
        int n = t.length();
        int m = p.length();
        while(i<n&&j<m){
            if(t.charAt(i)==p.charAt(j)){
                i++;j++;
            }
            else{
                if(j!=0){
                    j = lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return j==m;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String t = serialize(root);
        String p = serialize(subRoot);
        return kmp(t, p);
    }
}
