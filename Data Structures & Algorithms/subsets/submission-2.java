class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        f(0,new ArrayList<>(),nums);
        return ans;
    }
    private void f(int i, List<Integer> temp, int[] nums) {
        if(i == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);//take
        f(i+1, temp, nums);
        temp.remove(temp.size() - 1);//notTake;
        f(i+1, temp, nums);
    }
}
