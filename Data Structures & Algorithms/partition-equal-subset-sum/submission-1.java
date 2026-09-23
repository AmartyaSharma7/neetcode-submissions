class Solution {
    private int dfs(int ind,int[] nums,int target,int[][ ]dp){
        if(ind<0){
            if(target==0)return 1;
            return 0;
        }
        if(dp[ind][target]!=-1)return dp[ind][target];
        int notTake = dfs(ind-1,nums,target,dp);
        int take = 0;
        if(target >= nums[ind]){
            take = dfs(ind-1,nums,target-nums[ind],dp);
        }

        return dp[ind][target] = Math.max(take,notTake);
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0)return false;
        int[][] dp = new int[nums.length][sum/2 + 1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return dfs(nums.length-1,nums,sum/2,dp) == 1;
    }
}
