class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        if(nums.length < 2) {
            return new int[]{-1,-1};
        }

        for(int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            int res = target - sum;

            if(map.containsKey(res)) {
                return new int[] {map.get(res),i};
            }

            map.put(nums[i],i);
        }

        return new int[]{-1,-1};
    }
}
