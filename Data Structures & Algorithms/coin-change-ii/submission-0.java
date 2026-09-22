class Solution {
    public int dfs(int ind,int[] coins,int amount,int[][] dp){
        if(ind==0){
            if(amount%coins[ind] == 0){
                return 1;
            }
            return 0;
        }
        if(dp[ind][amount]!=-1)return dp[ind][amount];

        int notTake = dfs(ind-1,coins,amount,dp);
        int take = 0;
        if(amount>=coins[ind]){
            take = dfs(ind,coins,amount-coins[ind],dp);
        }
        return dp[ind][amount] = take+notTake;
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] it : dp){
            Arrays.fill(it,-1);
        }
        return dfs(coins.length-1,coins,amount,dp);
    }
}
