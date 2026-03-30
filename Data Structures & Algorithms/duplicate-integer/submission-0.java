class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> x = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(x.contains(nums[i])){
                return true;
            }

            x.add(nums[i]);
        }

        return false;
    }
}
