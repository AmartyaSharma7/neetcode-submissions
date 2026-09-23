class Solution {
    public int[] delRow = {-1,0,1,0};
    public int[] delCol = {0,1,0,-1};

    public boolean isValid(int r , int c, int n , int m){
        if(r<0 || r==n || c<0 || c==m)return false;
        return true;
    }

    public void dfs(int row,int col,char[][] grid){
        grid[row][col] = 'V';
        for(int i=0;i<4;i++){
            int newRow = row+delRow[i];
            int newCol = col+delCol[i];
            if(isValid(newRow,newCol,grid.length,grid[0].length) && grid[newRow][newCol]=='O'){
                dfs(newRow,newCol,grid);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0 || i==n-1 || j==m-1) && board[i][j]=='O')
                dfs(i,j,board);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='V'){
                    board[i][j]='O';
                }
            }
        }

    }
}
