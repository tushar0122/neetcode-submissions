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
    public List<List<Integer>> levelOrder(TreeNode root) {
        var q = new LinkedList<TreeNode>();
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        if(root==null){
            return r;
        }
        q.add(root);
        q.add(null);
        while(q.size()>0){
            var l = new ArrayList<Integer>();
            while(q.peek()!=null){
                var t = q.poll();
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
                l.add(t.val);
            }
            q.pop();
            if(q.size()>0){
                q.add(null);
            }
            r.add(l);
        }
        return r;
    }
}
