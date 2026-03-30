class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> mpps = new HashMap<>();
        HashMap<Character, Integer> mppt = new HashMap<>();

        for(int i =0;i<s.length();i++){
            mpps.put(s.charAt(i), mpps.getOrDefault(s.charAt(i),0) + 1);
            mppt.put(t.charAt(i), mppt.getOrDefault(t.charAt(i),0) + 1);
        }

        return mpps.equals(mppt);
    }
}
