class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                int[] curr = stack.pop();
                int index = curr[1];
                res[index] = i - index;
            }
            stack.push(new int[]{temperatures[i], i});
        }

        return res;
    }
}