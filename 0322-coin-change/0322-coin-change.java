class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int c = 0; c <= amount; c++){
            for(int i = 0; i < coins.length; i++){
                if(coins[i] <= c){
                    dp[c] = Math.min(dp[c], dp[c-coins[i]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}