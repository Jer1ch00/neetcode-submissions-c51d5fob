class Solution {
    private void reverse(int start, int end, int[] nums){
        if(start>end) {
            return;
        }
        while(start<=end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n==0 || n==1) {
            return;
        }
        k = k%n; // this ensures that if k>n only leftovers are rotated and
        //no full rotations

        reverse(0,n-k-1,nums);
        reverse(n-k,n-1,nums);
        reverse(0,n-1,nums);
    }
}