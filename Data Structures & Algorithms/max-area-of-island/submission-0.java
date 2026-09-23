class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ans = Math.max(bfs(grid,i,j),ans);
                }
            }
        }
        return ans;
    }
    public boolean isValid(int r,int c,int n,int m){
        if(r<0 || c<0 || r==n ||c==m)return false;
        return true;
    }
    public int bfs(int[][] grid,int row,int col){
        Queue<int[]>q = new LinkedList<>();
        q.offer(new int[]{row,col});
        int sum = 0;
        grid[row][col]=0;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,-1,0,1};

        while(!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];

            for(int i=0;i<4;i++){
                int nr = r+delRow[i];
                int nc = c+delCol[i];

                if(isValid(nr,nc,grid.length,grid[0].length) && grid[nr][nc]==1){
                    q.offer(new int[]{nr,nc});
                    grid[nr][nc]=0;
                }
            }
            sum++;
        }
        return sum;
    }
}
