class Solution {
    Boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        return dfs(s, wordDict, 0);
    }

    private boolean dfs(String s, List<String> wordDict, int i) {
        if (i == s.length()) {
            return true;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        for (String word : wordDict) {
            int len = word.length();

            if (i + len <= s.length() &&
                s.substring(i, i + len).equals(word)) {

                if (dfs(s, wordDict, i + len)) {
                    dp[i] = true;
                    return true;
                }
            }
        }

        dp[i] = false;
        return false;
    }
}