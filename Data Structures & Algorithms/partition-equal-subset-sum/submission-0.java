class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) {
            return false;
        }
        int target = sum/2;
        dp = new Boolean[nums.length][target + 1];

        return f(nums.length - 1,target,nums);
    }

    private boolean f(int i, int target, int[] nums) {
        if(target == 0) {
            return true;
        }
        if(i==0) {
            return nums[0] == target ? true : false;
        }

        if(i<0 || target <0) {
            return false;
        }

        if(dp[i][target] != null) {
            return dp[i][target];
        }
        boolean notTake = f(i-1,target,nums);
        boolean take = false;
        if(nums[i] <= target) {
            take = f(i-1, target - nums[i], nums);
        }

        return take || notTake;
    }
}
