class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSoFar = 0;
        int curr = 0;
        int minSoFar = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            maxSoFar = Math.max(maxSoFar, curr);
            minSoFar = Math.min(minSoFar, curr);
        }

        return maxSoFar-minSoFar;
    }
}