class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(candidates);
        f(candidates, target, comb, 0);
        return res;
    }

    private void f(int[] candidates, int target, List<Integer> comb, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        if(target < 0 || i >= candidates.length) {
            return;
        }
        comb.add(candidates[i]);
        f(candidates, target - candidates[i], comb, i+1);
        comb.remove(comb.size() - 1);

        while(i+1 < candidates.length && candidates[i] == candidates[i+1]) {
            i++;
        }

        f(candidates, target, comb, i+1);
    }
}
