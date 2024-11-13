class Solution {
    public int minSubArrayLen(int target, int[] nums) {
         int sum = 0;
         int count = Integer.MAX_VALUE;
         int i = 0;
         int j = 0;
         while (i <= j && j < nums.length) {
            sum += nums[j];
            if (sum < target) {
                j++;
            } else {
                count = Math.min(j-i+1, count);
                i++;
                j = i;
                sum = 0;
            }
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }
}