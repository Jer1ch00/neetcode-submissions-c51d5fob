class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        f(0,s, new ArrayList<>());
        return res;
    }

    private void f(int i, String s, ArrayList<String> parts) {
        if(i == s.length()) {
            res.add(new ArrayList<>(parts));
            return;
        }

        for(int j=i;j<s.length();j++) {
            if(isPalindrome(s,i,j)) {
                parts.add(s.substring(i,j+1));
                f(j+1,s,parts);
                parts.remove(parts.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        while(start<=end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}