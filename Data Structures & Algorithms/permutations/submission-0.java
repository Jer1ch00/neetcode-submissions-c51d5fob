class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        f(nums,temp,0);
        return res;
    }

    private void f(int[] nums, List<Integer> temp, int i) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (temp.contains(nums[j])) continue;
            temp.add(nums[j]);
            f(nums,temp,i+1);
            temp.remove(temp.size() - 1);
        }
    }
}