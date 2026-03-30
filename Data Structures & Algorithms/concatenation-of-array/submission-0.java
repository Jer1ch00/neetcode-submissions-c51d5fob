class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2*nums.length];
        int i=0;
        int k = 0;

        while(k<nums.length) {
            ans[i] = nums[k];
            i++;
            k++;
        }

        k = 0;
        while(k<nums.length) {
            ans[i] = nums[k];
            i++;
            k++;
        }

        return ans;
        
    }
}