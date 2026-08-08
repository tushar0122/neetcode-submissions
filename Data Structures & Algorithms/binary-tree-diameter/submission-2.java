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

    public int[] diameterOfBinaryTreeRec(TreeNode root) {
        if(root==null){
            return new int[]{0, 0};
        }
        var rl = diameterOfBinaryTreeRec(root.left);
        var rr = diameterOfBinaryTreeRec(root.right);
        rl[0]=Math.max(rl[1]+rr[1], rl[0]);
        return new int[]{Math.max(rl[0], rr[0]), Math.max(rl[1], rr[1])+1};
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        return diameterOfBinaryTreeRec(root)[0];
    }
}
