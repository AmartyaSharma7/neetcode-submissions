class Solution {
    public int dfs(int r,int c,int[][] dp){
        if(r==0 && c==0){
            return 1;
        }
        if(r<0 || c<0){
            return 0;
        }
        if(dp[r][c]!=-1)return dp[r][c];

        int top = dfs(r-1,c,dp);
        int left = dfs(r,c-1,dp);

        return dp[r][c] = top+left;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(m-1,n-1,dp);
    }
}
