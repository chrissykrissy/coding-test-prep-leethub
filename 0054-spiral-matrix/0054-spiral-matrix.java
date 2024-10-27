class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        spiral(matrix, matrix.length, matrix[0].length, ret, 0, -1, 0, 1);
        return ret;
    }

    public void spiral(int[][]matrix, int m, int n, List<Integer> ret, int r, int c, int dr, int dc){
        if(m == 0 || n == 0) return;
        for (int i = 0; i < n; i++){
            r = r + dr;
            c = c + dc;
            ret.add(matrix[r][c]);
        }
        spiral(matrix, n, m-1, ret, r, c, dc, -dr);
    }
}