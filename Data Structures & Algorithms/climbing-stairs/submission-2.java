class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return f(n, dp);
    }

    private int f(int n, int[] dp) {
        if(n<=2) {
            return n;
        }
        if(dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = f(n-1,dp) + f(n-2,dp);
    }
}
