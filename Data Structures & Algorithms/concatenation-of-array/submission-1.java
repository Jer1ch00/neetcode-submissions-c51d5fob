class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];
        for(int i = 0; i<ans.length; i++) {
            if(i<nums.length) {
                ans[i] = nums[i];
            } else {
                ans[i] = nums[i-n];
            }
        }
        return ans;
    }
}