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
    void dfs(TreeNode root, ArrayList<Integer> l, int h){
        if(root==null){
            return;
        }
        if(l.size()<=h){
            l.add(root.val);
        }
        dfs(root.right, l, h+1);
        dfs(root.left, l, h+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        var l = new ArrayList<Integer>();
        dfs(root, l, 0);
        return l;
    }
}
