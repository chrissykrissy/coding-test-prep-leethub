class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int curr = 0; curr < temperatures.length; curr++){
            int currT = temperatures[curr];
            while(!stack.isEmpty() && temperatures[stack.peek()] < currT){
                int prev = stack.pop();
                days[prev] = curr - prev;
            }
            stack.push(curr);
        }
        return days;
    }
}