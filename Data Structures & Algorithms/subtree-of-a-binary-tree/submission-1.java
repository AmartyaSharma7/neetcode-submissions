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
    private boolean isSame(TreeNode p , TreeNode q){
        if(p==null && q==null)return true;
        if(p==null || q==null || p.val!=q.val)return false;
        return isSame(p.left,q.left) && isSame(p.right,q.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null)return true;
        if(root==null || subRoot==null)return false;
        if(isSame(root,subRoot))return true;
        boolean inLeft = isSame(root.left,subRoot);
        boolean inRight = isSame(root.right,subRoot);
        return inLeft || inRight || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
}
