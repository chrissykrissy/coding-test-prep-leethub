class Solution {
    int min = Integer.MAX_VALUE;
    int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int getFood(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '*'){
                    return bfs(grid, i, j, 0, visited);
                }
            }
        }
        return -1;
    }
    public int bfs(char[][] grid, int i , int j, int dist, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j, dist});
        visited[i][j] = true;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(grid[curr[0]][curr[1]] == '#'){
                return curr[2];
            }
            for(int[] d : dir){
                int ni = curr[0]+d[0];
                int nj = curr[1]+d[1];
                if(ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[ni].length && !visited[ni][nj] && grid[ni][nj] != 'X'){
                    q.add(new int[]{ni, nj, curr[2]+1});
                    visited[ni][nj] = true;
                }
            }
        }
        return -1;
    }
}