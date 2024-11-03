class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] matrix = new int[rowSum.length][colSum.length];

        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                int smallest = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= smallest;
                colSum[j] -= smallest;
                matrix[i][j] = smallest;
            }
        }
        return matrix;
    }
}