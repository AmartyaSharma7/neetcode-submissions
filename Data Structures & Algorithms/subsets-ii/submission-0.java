class Solution {
    private void dfs(int ind,int[] nums,List<List<Integer>> res,List<Integer> curr){
        res.add(new ArrayList<>(curr));

        for(int i=ind;i<nums.length;i++){
            if(i>ind && nums[i]==nums[i-1]){
                continue;
            }
            curr.add(nums[i]);
            dfs(i+1,nums,res,curr);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(0,nums,res,curr);
        return res;
    }
}
