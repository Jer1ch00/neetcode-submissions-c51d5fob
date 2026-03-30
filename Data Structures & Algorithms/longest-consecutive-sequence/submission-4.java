class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num: nums) {
            set.add(num);
        }
        int maxi = 0;
        for(int it : set) {
            if(!set.contains(it - 1)) {
                int curr = 1;
                while(set.contains(it + 1)) {
                    curr++;
                    it++;
                }

                maxi = Math.max(maxi, curr);
            }
        }

        return maxi;
    }
}
