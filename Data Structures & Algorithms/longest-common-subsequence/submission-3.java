class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return f(0,0,text1,text2);
    }
    private int f(int i, int j, String str1, String str2) {
        if(i>= str1.length() || j>= str2.length()) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(str1.charAt(i) == str2.charAt(j)) {
            return dp[i][j] =  1 + f(i+1, j+1, str1, str2);
        }

        return dp[i][j] = Math.max(f(i+1,j,str1,str2), f(i,j+1,str1,str2));
    }
}



