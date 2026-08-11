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
    void dfs(TreeNode root, int[] r, int mx){
        if(root==null){
            return;
        }
        if(root.val>=mx){
            mx = root.val;
            r[0]++;
        }
        dfs(root.left, r, mx);
        dfs(root.right, r, mx);
    }
    public int goodNodes(TreeNode root) {
        int[] r = new int[1];
        dfs(root, r, -1000);
        return r[0];
    }
}
