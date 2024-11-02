class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(-1);
        int length = heights.length;
        int maxArea = 0;

        for(int i = 0; i < heights.length; i++){
            while(stk.peek() != -1 && heights[stk.peek()] >= heights[i]){
                int currH = heights[stk.pop()];
                int currW = i - stk.peek()-1;
                maxArea = Math.max(maxArea, currH * currW);
            }
            stk.push(i);
        }

        while(stk.peek() != -1){
            int currH = heights[stk.pop()];
            int currW = length - stk.peek()-1;
            maxArea = Math.max(maxArea, currH * currW);
        }
        return maxArea;
    }
}