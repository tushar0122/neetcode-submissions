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
    public boolean isBalanced(TreeNode root) {
        boolean [] b = new boolean[1];
        b[0]=true;
        height(root, b);
        return b[0];
    }

    public int height(TreeNode root, boolean [] b) {
        if(root==null){
            return 0;
        }
        var hl = height(root.left, b);
        var hr = height(root.right, b);
        if(Math.abs(hr-hl)>1){
            b[0]=b[0]&&false;
        }
        return Math.max(hl, hr)+1;
    }

}
