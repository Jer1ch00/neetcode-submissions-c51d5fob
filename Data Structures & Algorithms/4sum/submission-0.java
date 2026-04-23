class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip the duplicates outside
            for (int j = i + 1; j < nums.length-2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicates inside
                int rem = nums[i] + nums[j];
                int l = j+1, r = nums.length-1;
                long req = (long)target - (long)rem;
                while (l < r) {
                    long temp = nums[l] + nums[r];
                    if (req == temp) {
                        res.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (temp < req)
                        l++;
                    else
                        r--;
                }
            }
        }
        return new ArrayList<>(res);
    }

}