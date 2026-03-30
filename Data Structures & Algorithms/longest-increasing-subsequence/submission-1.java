class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length + 1];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return f(0,-1,nums);
    }
    public int f(int i, int j, int[] nums) {
        if(i == nums.length) {
            return 0;
        }
        if(dp[i][j+1] != -1) {
            return dp[i][j+1];
        }

        int notTake = f(i+1,j,nums);
        int take = 0;

        if(j == -1 || nums[j]<nums[i]) {
            take = 1 + f(i+1,i,nums);
        }

        return dp[i][j+1] = Math.max(take,notTake);
    }
}