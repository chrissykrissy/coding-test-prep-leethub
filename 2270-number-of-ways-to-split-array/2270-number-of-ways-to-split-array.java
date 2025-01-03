class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] rightsum = new long[nums.length];
        long[] leftsum = new long[nums.length];
        
        //calc right
        long sumR = 0;
        for (int i = 0; i < nums.length; i++) {
            sumR += nums[i];
            rightsum[i] = sumR;
        } 

        //calc left
        long sumL = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            sumL += nums[i];
            leftsum[i] = sumL;
        }

        int count = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (rightsum[i] >= leftsum[i+1]){
                count++;
            }
        }
        return count;
    }
}