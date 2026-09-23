class Solution {
    public int dfs(int index,int[] nums,int[] dp){
        if(index<0){
            return 0;
        }

        if(dp[index]!=-1)return dp[index];

        int notTake = dfs(index-1,nums,dp);
        int take = nums[index] + dfs(index-2,nums,dp);
        
        return dp[index] = Math.max(take,notTake);
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return dfs(nums.length-1,nums,dp);
    }
}
