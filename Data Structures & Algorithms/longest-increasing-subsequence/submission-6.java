class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(0, -1, nums);
    }

    private int f(int currInd, int prevInd, int[] nums) {
        if(currInd >= nums.length) {
            return 0;
        }
        if(dp[currInd][prevInd + 1] != -1) {
            return dp[currInd][prevInd + 1];
        }
        int notTake = f(currInd + 1, prevInd, nums);
        int take = 0;
        if(prevInd == -1 || nums[currInd] > nums[prevInd]) {
            take = 1 + f(currInd + 1, currInd, nums);
        }

        return dp[currInd][prevInd + 1] = Math.max(take, notTake);
    }
}
