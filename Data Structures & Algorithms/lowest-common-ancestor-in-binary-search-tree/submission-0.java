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

    public boolean[] haveNode(TreeNode root, TreeNode p, TreeNode q, TreeNode[] res){
        if(root==null){
            return new boolean[2];
        }
        boolean [] r = new boolean[2];
        if(root==p){
            r[0]=true;
        }
        else if(root==q){
            r[1]=true;
        }
        var rl = haveNode(root.left, p, q, res);
        var rr = haveNode(root.right,p, q, res);
        r[0]=r[0]||(rl[0]||rr[0]);
        r[1]=r[1]||(rl[1]||rr[1]);
        if(r[0]&&r[1]){
            if(res[0]==null){
                res[0]=root;
            }
        }
        return r;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] res = new TreeNode[1];
        haveNode(root, p, q, res);
        return res[0];
    }
}
