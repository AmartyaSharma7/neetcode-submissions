class Solution {
    private void dfs(int ind,int[] nums,List<Integer>res,List<List<Integer>> ans){
        if(ind>=nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }
        res.add(nums[ind]);
        dfs(ind+1,nums,res,ans);
        res.remove(res.size()-1);
        dfs(ind+1,nums,res,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(0,nums,res,ans);
        return ans;
    }
}
