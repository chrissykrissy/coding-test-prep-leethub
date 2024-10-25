class Solution {
    int time = 0; 
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j, 0});
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            time = Math.max(time, curr[2]);
            for(int[] d : dir){
                int nx = curr[0]+d[0];
                int ny = curr[1]+d[1];
                if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[nx].length && grid[nx][ny] == 1){
                    q.offer(new int[]{nx, ny, curr[2]+1});
                    grid[nx][ny] = 2;
                }
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        
        return time;
    }
}