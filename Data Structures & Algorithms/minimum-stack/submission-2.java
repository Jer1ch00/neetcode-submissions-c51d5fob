class MinStack {
    private Deque<Integer> stack = new ArrayDeque<>();
  
    // minValuesStack keeps track of the minimum values at each state of the stack.
    private Deque<Integer> minValuesStack = new ArrayDeque<>();
    public MinStack() {
        minValuesStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
         stack.push(val);
        // Push the smaller between the current value and the current minimum onto the minValuesStack.
        minValuesStack.push(Math.min(val, minValuesStack.peek()));
    }
    
    public void pop() {
         stack.pop();
        // Remove the top element of the minValuesStack, which corresponds to the minimum at that state.
        minValuesStack.pop();
    }
    
    public int top() {
        
        return stack.peek();
    }
    
    public int getMin() {
        return minValuesStack.peek();
    }
}
