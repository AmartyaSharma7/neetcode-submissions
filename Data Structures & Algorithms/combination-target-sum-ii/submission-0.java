class Solution {
    private void dfs(int ind,int[] nums,int target,List<Integer> curr,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(ind>=nums.length || target<0){
            return;
        }
        curr.add(nums[ind]);
        dfs(ind+1,nums,target-nums[ind],curr,res);
        curr.remove(curr.size()-1);
        while(ind+1 < nums.length && nums[ind]==nums[ind+1]){
            ind++;
        }
        dfs(ind+1,nums,target,curr,res);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0,candidates,target,curr,res);
        return res;
    }
}
