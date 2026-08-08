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

    public int depthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(depthOfBinaryTree(root.left), depthOfBinaryTree(root.right))+1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        var dl = depthOfBinaryTree(root.left);
        var dr = depthOfBinaryTree(root.right);
        var ddl = diameterOfBinaryTree(root.left);
        var ddr = diameterOfBinaryTree(root.right);
        ddl = Math.max(dl+dr, ddl);
        return Math.max(ddl, ddr);
    }
}
