class Solution {
    public int dfs(int ind,int[] nums,int buy,int[][] dp){
        if(ind>=nums.length){
            return 0;
        }
        if(dp[ind][buy]!=-1)return dp[ind][buy];
        //if i can buy
        if(buy==1){
            dp[ind][buy] = Math.max(-1 * nums[ind] + dfs(ind+1,nums,0,dp),
                            dfs(ind+1,nums,1,dp));
        }
        else{
            dp[ind][buy] =  Math.max(nums[ind] + dfs(ind+2,nums,1,dp),
                            dfs(ind+1,nums,0,dp));
        }
        return dp[ind][buy];
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        return dfs(0,prices,1,dp);
    }
}
