class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = nums[0];
        int maxSoFar = 0;
        int minSoFar = 0;
        int min = nums[0];
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            maxSoFar = Math.max(maxSoFar+nums[i], nums[i]);
            max = Math.max(max, maxSoFar);
            minSoFar = Math.min(minSoFar+nums[i], nums[i]);
            min = Math.min(min, minSoFar);
            total += nums[i];
        }
        if (min == total) {
            return max;
        }
        return Math.max(max, total - min);
    }
}