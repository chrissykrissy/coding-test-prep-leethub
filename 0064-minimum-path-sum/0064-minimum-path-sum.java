class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, 300));
        dp[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) continue;
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }else{
                    if (i == 0) {
                        dp[i][j] = dp[i][j-1] + grid[i][j];
                    }else if (j == 0) {
                        dp[i][j] = dp[i-1][j] + grid[i][j];
                    }
                }
            }
        }

        return dp[grid.length-1][grid[grid.length-1].length-1];
    }
}