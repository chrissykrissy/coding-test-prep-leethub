class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = 0;
        int prev = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > prev) {
                sum += nums[i];
                prev = nums[i];
            } else {
                max = Math.max(max, sum);
                prev = nums[i];
                sum = nums[i];
            }
        }
        max = Math.max(max, sum);
        return max;
    }
}