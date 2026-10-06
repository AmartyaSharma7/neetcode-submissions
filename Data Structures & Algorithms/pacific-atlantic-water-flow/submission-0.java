class Solution {
    private static final int[] delRow = {-1,0,1,0};
    private static final int[] delCol = {0,1,0,-1};
    
     private void dfs(int r, int c, int[][] heights, boolean[][] ocean) {
        ocean[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + delRow[i];
            int nc = c + delCol[i];
            if (nr < 0 || nc < 0 ||
                nr >= heights.length ||
                nc >= heights[0].length) {
                continue;
            }
            if (ocean[nr][nc]) {
                continue;
            }
            if (heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, heights, ocean);
            }
        }
    }



    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific: top row + left column
        for (int j = 0; j < n; j++) {
            dfs(0, j, heights, pacific);
        }

        for (int i = 0; i < m; i++) {
            dfs(i, 0, heights, pacific);
        }

        // Atlantic: bottom row + right column
        for (int j = 0; j < n; j++) {
            dfs(m - 1, j, heights, atlantic);
        }

        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, heights, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
}
