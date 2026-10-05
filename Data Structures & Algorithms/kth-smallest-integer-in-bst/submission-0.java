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
    private void dfs(TreeNode root,List<Integer> ls){
        if(root==null)return;
        dfs(root.left,ls);
        ls.add(root.val);
        dfs(root.right,ls);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ls = new ArrayList<>();
        dfs(root,ls);
        if(root==null || k>ls.size())return 0;
        return ls.get(k-1);
    }
}
