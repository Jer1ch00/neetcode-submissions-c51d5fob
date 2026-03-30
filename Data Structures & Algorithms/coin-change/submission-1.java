class Solution {
    int[] dp;
    public int dfs(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        if(dp[amount] != -1) {
            return dp[amount];
        }
        int res = (int) 1e9;
        for(int coin : coins) {
            if(amount - coin >= 0) {
                res = Math.min(res, 1 + dfs(coins, amount - coin));
            }
        }
        return dp[amount] = res;
    }
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp,-1);
        int minCoins = dfs(coins, amount);
        return (minCoins >= 1e9) ? -1 : minCoins;
    }
}
