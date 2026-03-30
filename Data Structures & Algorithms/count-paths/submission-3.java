class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        for(int j = 0 ; j<n ; j++) {
            dp[m-1][j] = 1;
        }

        for(int i = 0 ; i<m ; i++) {
            dp[i][n-1] = 1;
        }
        for(int i = m-2; i>=0; i--) {
            for(int j = n-2; j>=0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }

    // private int f(int i, int j, int m, int n,int[][] dp) {
    //     if(i>=m || j>=n) {
    //         return 0;
    //     }

    //     if(i == m-1 && j == n-1) {
    //         return 1;
    //     }

    //     if(dp[i][j] != -1) {
    //         return dp[i][j];
    //     }

    //     return dp[i][j] = f(i+1,j,m,n,dp) + f(i,j+1,m,n,dp);
    // }
}
