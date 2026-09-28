class Solution {
    private int dfs(int r,int c,int[][] matrix,int[][] dp){
        if(r<0 || c<0 || r==matrix.length || c==matrix[0].length){
            return 0;
        }

        if(dp[r][c]!=-1)return dp[r][c];
        int ans = 1;

        if(r+1<matrix.length &&matrix[r+1][c] > matrix[r][c]){
           ans = Math.max(ans,1+dfs(r+1,c,matrix,dp));
        }
        if(c+1<matrix[0].length && matrix[r][c+1] > matrix[r][c]){
            ans = Math.max(ans,1+dfs(r,c+1,matrix,dp));
        }        
        if(r-1 >=0 && matrix[r-1][c] > matrix[r][c]){
            ans = Math.max(ans,1+dfs(r-1,c,matrix,dp));
        }  
        if(c-1>=0 && matrix[r][c-1] > matrix[r][c]){
            ans = Math.max(ans,1+dfs(r,c-1,matrix,dp));
        }  
        return dp[r][c]=ans;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                ans = Math.max(dfs(i,j,matrix,dp),ans);
            }
        }
        return ans;
    }
}
