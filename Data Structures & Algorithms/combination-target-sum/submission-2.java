class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
         f(0,nums,target,ans,new ArrayList<>());
         return ans;
    }

    private void f(int i, int[] nums, int target, List<List<Integer>> ans, List<Integer> comb ) {
        if(target == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        if (target < 0 || i >= nums.length) {
            return;
        }
        

        

        //take case
        
        comb.add(nums[i]);
        f(i,nums,target-nums[i],ans,comb);
        

        comb.remove(comb.size() - 1);
        f(i+1,nums,target,ans,comb);
       
    }
}
