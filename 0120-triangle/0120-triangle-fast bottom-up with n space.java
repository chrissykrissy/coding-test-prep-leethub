class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp 배열을 선언하여 마지막 행의 크기로 초기화
        int[] dp = new int[n];
        // 삼각형의 마지막 행을 dp에 복사
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // 아래에서 위로 dp 업데이트
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        // dp[0]에는 최종 결과가 저장됨
        return dp[0];
    }
}