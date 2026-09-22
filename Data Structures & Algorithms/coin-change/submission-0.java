class Solution {
    public int dfs(int ind,int[] coins,int amount,int[][] dp){
        if(ind==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }
            return (int)1e9;
        }
        if(dp[ind][amount]!=-1)return dp[ind][amount];

        int notTake = dfs(ind-1,coins,amount,dp);
        int take = (int)1e9;
        if(coins[ind]<=amount)
        take = 1+dfs(ind,coins,amount-coins[ind],dp);

        return dp[ind][amount] = Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans = dfs(coins.length-1,coins,amount,dp);
        if(ans == (int)1e9)return -1;
        return ans;
    }
}
