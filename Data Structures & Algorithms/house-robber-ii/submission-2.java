class Solution {

    int f(int i, int end, int[] nums, int[] dp) {
        // Base case
        if (i > end) {
            return 0;
        }

        // Memo check
        if (dp[i] != -1) {
            return dp[i];
        }

        // Choices
        int rob = nums[i] + f(i + 2, end, nums, dp);
        int skip = f(i + 1, end, nums, dp);

        return dp[i] = Math.max(rob, skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        // Case 1: 0 to n-2
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = f(0, n - 2, nums, dp1);

        // Case 2: 1 to n-1
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = f(1, n - 1, nums, dp2);

        return Math.max(case1, case2);
    }
}