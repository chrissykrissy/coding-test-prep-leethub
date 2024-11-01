class Solution {
    class Pair{
        int index;
        int height;
        Pair(int index, int height){
            this.index = index;
            this.height = height;
        }
    }
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < heights.length; i++){
            int start = i;
            while (!st.isEmpty() && st.peek().height > heights[i]){
                Pair p = st.pop();
                maxArea = Math.max(maxArea, p.height * (i-p.index));
                start = p.index;
            }
            st.push(new Pair(start, heights[i]));
        }

        for(Pair pp : st){
            maxArea = Math.max(maxArea, pp.height * (heights.length-pp.index));
        }
        return maxArea;

    }
}