class Solution {
    private int dfs(int ind,int buy,int[] nums,int[][] dp){
        if(ind == nums.length){
            return 0;
        }
        if(dp[ind][buy]!=-1)return dp[ind][buy];
        if(buy==1){
            dp[ind][buy] = Math.max(-nums[ind]+dfs(ind+1,0,nums,dp) , dfs(ind+1,1,nums,dp));
        }
        else{
            dp[ind][buy] = Math.max(nums[ind]+dfs(ind+1,1,nums,dp) , dfs(ind+1,0,nums,dp));
        }
        return dp[ind][buy];
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] it : dp){
                Arrays.fill(it,-1);
        }
        return dfs(0,1,prices,dp);
    }
}