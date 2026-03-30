class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return f(s,0);
    }

    public int f(String s, int i) {
        if(i == s.length()) {
            return 1;
        }

        if(s.charAt(i) == '0') {
            return 0;
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        int ways = f(s,i+1);

        if(i+1 < s.length()) {
            if(s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7') {
                ways += f(s,i+2);
            }
        }

        dp[i] = ways;
        return ways;
    }
}
