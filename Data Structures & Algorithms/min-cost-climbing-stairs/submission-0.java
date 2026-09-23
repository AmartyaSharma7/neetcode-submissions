class Solution {
    public int dfs(int index,int[] cost,int[] dp){
        if(index==0 || index==1){
            return cost[index];
        }
        if(dp[index]!=-1)return dp[index];
        int oneStep = dfs(index-1,cost,dp);
        int twoStep = dfs(index-2,cost,dp);

        return dp[index] = cost[index] + Math.min(oneStep,twoStep);
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(dfs(cost.length-1,cost,dp),dfs(cost.length-2,cost,dp));
    }
}
