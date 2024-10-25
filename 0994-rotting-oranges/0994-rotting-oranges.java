class Solution {
    public int orangesRotting(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) rot(grid, i, j, 2);
            }
        }
        int min = 2;
        for (int[] row : grid){
            for(int cell : row){
                if (cell == 1) return -1;
                min = Math.max(min, cell);
            }
        }
        return min - 2;
    }

    public void rot(int[][]grid, int i, int j, int time){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || (1 < grid[i][j] && grid[i][j] < time)){
            return;
        }
        grid[i][j] = time;
        time += 1;
        rot(grid, i + 1, j, time);
        rot(grid, i - 1, j, time);
        rot(grid, i, j + 1, time);
        rot(grid, i, j -1, time);
    }
}