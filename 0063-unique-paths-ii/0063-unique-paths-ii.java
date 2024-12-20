class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 첫 행 초기화
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break; // 장애물 이후는 접근 불가능
            }
            dp[i][0] = 1;
        }

        // 첫 열 초기화
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break; // 장애물 이후는 접근 불가능
            }
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}