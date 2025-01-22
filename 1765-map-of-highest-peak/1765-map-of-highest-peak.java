class Solution {
    int[][] dir = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    public int[][] highestPeak(int[][] isWater) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < isWater.length; i++){
            for(int j = 0; j < isWater[0].length; j++){
                if(isWater[i][j] == 1){
                    q.add(new int[]{i, j});
                    isWater[i][j] = 0;
                }else{
                    isWater[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            int[] cell = q.poll();
            for(int[] d: dir){
                int ni = cell[0] + d[0];
                int nj = cell[1] + d[1];
                if(ni>= 0 && nj >= 0 && ni < isWater.length && nj < isWater[0].length && isWater[ni][nj] == -1){
                    isWater[ni][nj] = isWater[cell[0]][cell[1]]+1;
                    q.add(new int[]{ni, nj});
                }
            }
        }


        return isWater;
    }
}

/*
    for every cell, we need to find dist to nearest 0
    - if the cell itself is 0, then dist = 0
    - if the cell is not 0, then find 0
        - 
    */