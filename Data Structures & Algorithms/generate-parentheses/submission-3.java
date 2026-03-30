class Solution {
    StringBuilder str = new StringBuilder("");
    public void f(int open, int closed, int n, List<String> ans, StringBuilder str) {
        if(open ==n && closed == n) {
            ans.add(str.toString());
        }
        if(open < n) {
            str.append('(');
            f(open + 1, closed, n, ans , str);
            str.deleteCharAt(str.length() - 1);
        }
        if(closed < open) {
            str.append(')');
            f(open , closed + 1, n, ans , str);
            str.deleteCharAt(str.length() - 1);
        }

    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        f(0, 0, n, ans, str);
        return ans;
    }
}