class Solution {
    int[][] dp;
    private static final int prime = (int)(1e9 + 7);
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return f(0,0,s,t);
    }
    public int f(int i, int j, String s, String t) {
        if(j>=t.length()) {
            return 1;
        }

        if(i>=s.length()) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = (f(i+1,j+1,s,t) + f(i+1,j,s,t)) % prime; 
        } else {
            return dp[i][j]=f(i+1,j,s,t);
        }
    }
}


