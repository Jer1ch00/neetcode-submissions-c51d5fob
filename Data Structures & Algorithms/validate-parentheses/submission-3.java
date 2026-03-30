class Solution {
    public boolean isValid(String s) {
       Stack<Character> st = new Stack<>();

       for(char c : s.toCharArray()) {
        if(c=='(' || c=='{' || c =='[') {
            st.push(c);
        }
        else {
            if(st.isEmpty() || !(match(st.pop(),c))) {
                return false;
            }
        }
       }

       return st.isEmpty(); 
    }

    public boolean match(char left, char right) {
        return (left =='(' && right ==')') ||
                (left =='{' && right =='}')||
                (left =='[' && right ==']');
    }
}