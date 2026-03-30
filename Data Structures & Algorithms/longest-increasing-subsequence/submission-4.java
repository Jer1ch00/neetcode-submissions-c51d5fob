class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length + 1];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return dfs(nums,0,-1);
    }
    public int dfs(int[] nums, int curr, int prev) {
        if(curr == nums.length) {
            return 0;
        }

        if(dp[curr][prev + 1] != -1) {
            return dp[curr][prev+1];
        }
        int notTake = dfs(nums,curr+1,prev);
        int take = 0;
        if(prev == -1 || nums[prev] < nums[curr] ) {
            take = 1 + dfs(nums,curr+1,curr);
        }
        dp[curr][prev + 1] = Math.max(notTake,take);
        return Math.max(notTake,take);
    }
}
