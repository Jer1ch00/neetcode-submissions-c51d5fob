class Solution {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);

        int maxLis = 1;
        for(int i=0; i<nums.length; i++){
            maxLis = Math.max(maxLis,f(i,nums));
        }
        return maxLis;
    }
    public int f(int i, int[] nums) {
        if(dp[i] != -1) {
            return dp[i];
        }

        int LIS = 1;
        for(int j = i+1;j<nums.length;j++) {
            if(nums[j] > nums[i]) {
                LIS = Math.max(LIS, 1 + f(j,nums));
            }
        }
         dp[i] = LIS;

         return LIS;

       
    }
}