class Solution {
    public int orangesRotting(int[][] grid) {
        int freshFruits = 0;
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)freshFruits++;
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j,0});
                }    
            }
        }

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        int ans = 0;
        int rotten = 0;
        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            int time = node[2];

            for(int i=0;i<4;i++){
                int newRow = delRow[i]+row;
                int newCol = delCol[i]+col;

                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && grid[newRow][newCol]==1){
                    q.offer(new int[]{newRow,newCol,time+1});
                    grid[newRow][newCol]=2;
                    rotten++;
                }
                ans = Math.max(ans,time);
            }
        }
        if(rotten != freshFruits)return -1;
       return ans;
    }
}
