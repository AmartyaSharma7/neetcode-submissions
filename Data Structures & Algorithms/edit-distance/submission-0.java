class Solution {
    public int dfs(int i,int j, String word1,String word2,int[][] dp){
        if(i==word1.length()){
            return word2.length()-j;
        }
        else if(j==word2.length()){
            return word1.length()-i;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        //insert
        int insert = dfs(i,j+1,word1,word2,dp);
        //delete
        int delete = dfs(i+1,j,word1,word2,dp);
        //replace
        int replace = dfs(i+1,j+1,word1,word2,dp);

        if(word1.charAt(i) == word2.charAt(j))
             return dfs(i+1,j+1,word1,word2,dp);

        return dp[i][j] = 1+Math.min(insert,Math.min(delete,replace));
    }
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return dfs(0,0,word1,word2,dp);
    }
}
