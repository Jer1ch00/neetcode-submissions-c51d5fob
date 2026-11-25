public class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0, curSum = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1); //sum = 0 and count = 1;

        for (int num : nums) {
            curSum += num; //sum till now
            int diff = curSum - k; //sum remaining
            result += prefixSums.getOrDefault(diff, 0); // if diff exists return the count of subarrays
            prefixSums.put(curSum, prefixSums.getOrDefault(curSum, 0) + 1);
        }

        return result;
    }
}