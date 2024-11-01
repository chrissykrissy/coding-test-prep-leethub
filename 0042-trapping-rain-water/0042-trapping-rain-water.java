class Solution {
    public int trap(int[] height) {
        int i = 0, j = height.length-1;
        int leftMax = 0, rightMax = 0;
        int total = 0;
        while(i <= j){
            leftMax = Math.max(height[i], leftMax);
            rightMax = Math.max(height[j], rightMax);
            if(leftMax < rightMax){
                total += leftMax-height[i];
                i++;
            }else{
                total += rightMax-height[j];
                j--;
            }
        }
        return total;
    }
}