class Solution {
    public void islandsAndTreasure(int[][] grid) {
      Queue<int[]> q = new LinkedList<>();
      boolean[][] vis = new boolean[grid.length][grid[0].length];

      for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[i].length;j++){
            if(grid[i][j]==0){
                q.offer(new int[]{i,j,0});
                vis[i][j]=true;
            }
        }
      }

      int[] delRow = {-1,0,1,0};
      int[] delCol = {0,-1,0,1};

      while(!q.isEmpty()){
        int[] node = q.poll();
        int row = node[0];
        int col = node[1];
        int steps = node[2];

        for(int i=0;i<4;i++){
            int newRow = row+delRow[i];
            int newCol = col+delCol[i];

            if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol < grid[0].length && vis[newRow][newCol]==false && grid[newRow][newCol]!=-1){
                q.offer(new int[]{newRow,newCol,steps+1});
                grid[newRow][newCol]=steps+1;
                vis[newRow][newCol]=true;
            }
        }
      }

    }
}
