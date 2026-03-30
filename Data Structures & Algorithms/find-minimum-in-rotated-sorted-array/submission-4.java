class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[low]<=nums[mid]){ //eliminate the sorted portion
                ans = Math.min(ans,nums[low]);
                low = mid+1;
            }

            else{ //eliminate the sorted portion
                ans = Math.min(ans,nums[mid]);
                high = mid-1;
            }
        }

        return ans;
    }
}
//extract what you want and eliminate the sorted potion