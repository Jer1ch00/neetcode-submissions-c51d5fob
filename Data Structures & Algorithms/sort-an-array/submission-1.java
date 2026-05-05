class Solution {
    public int[] sortArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        mergeSort(nums,left,right);   

        return nums; 
    }

    private void mergeSort(int[] nums, int low, int high) {
        if(low>=high) {
            return;
        }

        int mid = (low+high)/2;

        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }

    private void merge (int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;
        while(left <= mid && right <= high) {
            if(nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }

        while(left<=mid) {
            temp.add(nums[left++]);
        }
        while(right<=high) {
            temp.add(nums[right++]);
        }

        for(int i=low;i<=high;i++) {
            nums[i] = temp.get(i-low);
        }
    }
}