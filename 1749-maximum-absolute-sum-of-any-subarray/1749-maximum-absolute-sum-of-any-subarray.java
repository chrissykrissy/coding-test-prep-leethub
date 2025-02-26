class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSoFar = 0;
        int curr = 0;
        int minSoFar = 0;
        int curr2 = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            curr2 += nums[i];
            maxSoFar = Math.max(maxSoFar, curr);
            minSoFar = Math.min(minSoFar, curr2);
        }

        return Math.max(Math.abs(maxSoFar-minSoFar),Math.max(Math.abs(minSoFar), Math.abs(maxSoFar)));
    }
}