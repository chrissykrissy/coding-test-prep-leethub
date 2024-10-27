class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int r = matrix.length;
        int c = matrix[0].length;
        if(r == 0) return res;
        boolean[][] visited = new boolean[r][c];
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int x = 0, y = 0, d = 0;
        while(res.size() < r * c){
            visited[x][y] = true;
            res.add(matrix[x][y]);
            int nx = x + dir[d%4][0];
            int ny = y + dir[d%4][1];
            if(nx >= 0 && ny >= 0 && nx < r && ny < c && !visited[nx][ny]){
                x = nx;
                y = ny;
            }else{
                d++;
                x += dir[d%4][0];
                y += dir[d%4][1];
            }
        }
        return res;
    }
}