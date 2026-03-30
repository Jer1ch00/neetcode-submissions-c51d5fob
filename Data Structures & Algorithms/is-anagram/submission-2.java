class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] characterS = s.toCharArray();
        char[] characterT = t.toCharArray();
        Arrays.sort(characterS);
        Arrays.sort(characterT);

        return Arrays.equals(characterS,characterT);
    }
}
