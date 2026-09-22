class Solution {
    public int dfs(int ind,int target,int[] nums,int[][] dp){
        if(ind==0){
            if(target==0 && nums[0]==0)return 2;
            if(target==nums[0] || target==0)return 1;
            return 0;
        }
        if(dp[ind][target]!=-1)return dp[ind][target];

        int notTake = dfs(ind-1,target,nums,dp);
        int take = 0;
        if(target >= nums[ind]){
            take = dfs(ind-1,target-nums[ind],nums,dp);
        }
        return dp[ind][target] = take+notTake;
    }
    public int findTargetSumWays(int[] nums, int target) {
        //sum1 - (sum2) = target. //sum2 is 0 -> add all
        //sum1+sum2 = total sum of array
        //sum1 - (totalSum-sum1) = target
        //sum1 = target+toatlSum/2
        //Need to find sum of a subarray whose target == target+totalsum/2

        int sum=0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int newTarget = (target+sum)/2;
        //Edge cases -> new target shouldn't be odd
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        //Target shouldn't be more than sum itself
        if (Math.abs(target) > sum) {
            return 0;
        }

        int[][] dp = new int[n][newTarget+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return dfs(n-1,newTarget,nums,dp);
    }
}
