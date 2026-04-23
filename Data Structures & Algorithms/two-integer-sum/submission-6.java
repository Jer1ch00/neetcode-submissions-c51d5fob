class Solution {
    private HashMap<Integer, Integer> mpp;
    public int[] twoSum(int[] nums, int target) {
        mpp = new HashMap<Integer,Integer>();
        if(nums.length < 2) {
            return new int[]{-1,-1};
        }
        
        for(int i=0;i<nums.length;i++) {
            // mpp.put(nums[i],i);
            int sum = 0;
            sum += nums[i];

            int res = target - sum;

            if(mpp.containsKey(res)) {
                return new int[]{mpp.get(res), i};
            }

            mpp.put(nums[i], i);
        }

        return new int[]{-1,-1};
    }
}