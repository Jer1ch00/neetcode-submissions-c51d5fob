class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // List<List<String>> res = new ArrayList<>();
        // List<String> temp = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] temp = new char[26];
            for(char ch : str.toCharArray()) {
                temp[ch-'a']++;
            }
            String key = Arrays.toString(temp);

            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
