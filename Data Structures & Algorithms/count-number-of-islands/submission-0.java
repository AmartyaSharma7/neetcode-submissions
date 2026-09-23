class Solution {
    public boolean isValid(int row,int col,int n,int m){
        if(row<0 || col<0 || row==n || col==m)return false;
        return true;
    }
    public int numIslands(char[][] grid) {
        //bfs
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void bfs(char[][] grid,int r,int c){
        Queue<int[]>q = new LinkedList<>();
        q.offer(new int[]{r,c});
        grid[r][c]=0;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,-1,0,1};
        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            //4 directions
            for(int i=0;i<4;i++){
                int newRow = row+delRow[i];
                int newCol = col+delCol[i];

                if(isValid(newRow,newCol,n,m) && grid[newRow][newCol]=='1'){
                    q.offer(new int[]{newRow,newCol});
                    grid[newRow][newCol]='0';
                }
            }
        }
    }
}
