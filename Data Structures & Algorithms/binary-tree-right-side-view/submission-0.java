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
    public List<Integer> rightSideView(TreeNode root) {
        //bfs only the first element
        //or dfs , take the right element , go left if right doesn't exist
    
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ls = new ArrayList<>();

        if(root==null)return ls;
        q.offer(root);
        int ans=0;

        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode nroot = q.poll();
                if(i==n-1){
                    ans = nroot.val;
                }
                if(nroot.left!=null){
                    q.offer(nroot.left);
                }
                if(nroot.right!=null){
                    q.offer(nroot.right);
                }
            }
            ls.add(ans);
        }
        return ls;
    }
}
