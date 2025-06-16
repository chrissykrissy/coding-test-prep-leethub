class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int diff = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < min) {
                min = nums[i];
                continue;
            } else {
                diff = Math.max(diff, nums[i] - min);
            }
        }
        if (diff < 0 || diff == 0) return -1;
        return diff;
    }
}