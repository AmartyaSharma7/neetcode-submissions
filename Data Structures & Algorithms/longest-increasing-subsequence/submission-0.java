class Solution {
    public int dfs(int ind,int prevInd,int[] nums,int[][] dp){
        if(ind==nums.length){
            return 0;
        }
        if(dp[ind][prevInd+1]!=-1)return dp[ind][prevInd+1];

        int skipElement = dfs(ind+1,prevInd,nums,dp);
        int takeElement = 0;
        if(prevInd == -1 || nums[ind]>nums[prevInd]){
            takeElement = 1+dfs(ind+1,ind,nums,dp);
        } 
        return dp[ind][prevInd+1] = Math.max(takeElement,skipElement);
    }
    public int lengthOfLIS(int[] nums) {
        //index and previous index
        //if the current element is greater than previous index element 
        //add it to the list
        int[][] dp = new int[nums.length][nums.length+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return dfs(0,-1,nums,dp);
    }
}
