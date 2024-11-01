class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        boolean[][] pac = new boolean[row][col];
        boolean[][] atl = new boolean[row][col];

        for(int c = 0; c < col; c++){
            dfs(0, c, row, col, pac, heights[0][c], heights);
            dfs(row-1, c, row, col, atl, heights[row-1][c], heights);
        }

        for(int r = 0; r < row; r++){
            dfs(r, 0, row, col, pac, heights[r][0], heights);
            dfs(r, col-1, row, col, atl, heights[r][col-1], heights);
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++){
                if (pac[i][j] && atl[i][j])
                    result.add(Arrays.asList(i,j));
            }
        return result;
    }

    private void dfs(int r, int c, int row, int col, boolean[][]visited, int prevH, int[][] heights){
        if(r < 0 || c < 0 || r >= row || c >= col || visited[r][c] || prevH > heights[r][c]){
            return;
        }
        visited[r][c] = true;
        dfs(r+1, c, row, col, visited, heights[r][c], heights);
        dfs(r-1, c, row, col, visited, heights[r][c], heights);
        dfs(r, c+1, row, col, visited, heights[r][c], heights);
        dfs(r, c-1, row, col, visited, heights[r][c], heights);
    }
}