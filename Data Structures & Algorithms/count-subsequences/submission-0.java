class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        dp = new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return f(m-1,n-1,s,t);
    }
    private int f(int i, int j, String s, String t) {
        if(j<0) {
            return 1;
        }

        if(i<0) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = f(i-1,j-1,s,t) + f(i-1,j,s,t);
        } 
            
        return dp[i][j] = f(i-1,j,s,t);
        

    }
}