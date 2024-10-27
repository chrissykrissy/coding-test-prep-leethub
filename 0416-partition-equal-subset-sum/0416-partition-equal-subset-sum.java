class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        // 전체 합이 홀수면 부분 집합으로 나눌 수 없습니다.
        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // 0 합은 항상 만들 수 있습니다.

        for(int num : nums){
            for(int j = target; j >= num; j--){
                dp[j] = dp[j] || dp[j-num];
            }
        }
        return dp[target];
    }
}