class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mpp = new HashMap<>();
        for(String str : strs) {
            int[] count = new int[26];
            for(char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            mpp.putIfAbsent(key, new ArrayList<>());
            mpp.get(key).add(str);
        }

        return new ArrayList<>(mpp.values());
    }
}
