class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int resIndex = 0;
        int resLen = 0;

        for(int i=0;i<n;i++) {
            int l = i;
            int r = i; // this is for the odd length since they have only one middle point
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)) {
                if(r-l+1 > resLen) {
                    resLen = r-l+1;
                    resIndex = l;
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1; // this is for the even length since they have only two middle point
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)) {
                if(r-l+1 > resLen) {
                    resLen = r-l+1;
                    resIndex = l;
                }
                l--;
                r++;
            }
        }

        return s.substring(resIndex, resIndex + resLen);
    }
}