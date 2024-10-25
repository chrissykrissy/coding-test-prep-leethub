class Solution {
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int numIsland = 0;
    public int numIslands(char[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    findIsland(grid, i, j);
                    numIsland++;
                }
            }
        }
        return numIsland;
    }
    private void findIsland(char[][] grid, int i, int j){
        grid[i][j] = '0';
        for(int[] d : dir){
            int ni = i+d[0];
            int nj = j+d[1];
            if(ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[ni].length && grid[ni][nj] == '1'){
                findIsland(grid, ni, nj);
            }
        }
    }
}