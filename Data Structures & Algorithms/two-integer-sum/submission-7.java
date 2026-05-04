class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length < 2) {
            return new int[]{-1,-1};
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int sum = 0;
            sum+=nums[i];

            int rem = target - sum;

            if(map.containsKey(rem)) {
                return new int[]{map.get(rem),i,};
            } else {
                map.put(nums[i],i);
            }
        }

        return new int[]{-1,-1};
    }
}
