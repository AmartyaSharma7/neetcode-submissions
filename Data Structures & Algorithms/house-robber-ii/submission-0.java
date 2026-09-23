class Solution {
    private int dfs(int index,int[] nums,int[] dp){
        if(index<0){
            return 0;
        }
        if(dp[index]!=-1)return dp[index];

        int notTake = dfs(index-1,nums,dp);
        int take = nums[index] + dfs(index-2,nums,dp);

        return dp[index] = Math.max(take,notTake); 
    }
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        
        int[] nums1 = new int[nums.length-1];
        int[] nums2 = new int[nums.length-1];

        int[] dp1 = new int[nums.length-1];
        int[] dp2 = new int[nums.length-1];

        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        for(int i=0;i<nums.length;i++){
            if(i!=0)
                nums1[i-1]=nums[i];
            if(i!=nums.length-1)
                nums2[i]=nums[i];
        }

        return Math.max(dfs(nums.length-2,nums1,dp1),dfs(nums.length-2,nums2,dp2));
    }
}
