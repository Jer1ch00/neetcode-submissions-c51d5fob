class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int minCoins = f(coins,amount);
        return (minCoins >= 1e9) ? -1 : minCoins;
    }

    public int f(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }

        if(dp[amount] != -1) {
            return dp[amount];
        }

        int res = (int) 1e9;

        for(int coin : coins) {
            if(amount - coin >= 0) {
                res = Math.min(res, 1 + f(coins, amount - coin));
            }
        }
        dp[amount] = res;
        return res;
    }
}
