class Solution {
    public int dfs(int ind1,int ind2,String text1,String text2,int[][] dp){
        if(ind1<0 || ind2<0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];
        //move one step from text1 or one step from text2 or one from both
        int oneByt1 = dfs(ind1-1,ind2,text1,text2,dp);
        int oneByt2 = dfs(ind1,ind2-1,text1,text2,dp);
        int oneByBoth = 0;
        if(text1.charAt(ind1) == text2.charAt(ind2)){
             oneByBoth = 1+dfs(ind1-1,ind2-1,text1,text2,dp);
        }
        

        return dp[ind1][ind2] = Math.max(Math.max(oneByt1,oneByt2),oneByBoth);
        
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return dfs(text1.length()-1,text2.length()-1,text1,text2,dp);
    }
}
