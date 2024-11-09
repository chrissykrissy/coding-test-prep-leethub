class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int reachable = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i <= reachable) {
                reachable = Math.max(reachable, i + nums[i]);
            }
            if (reachable >= nums.length-1) {
                return true;
            }
        }
        return false;
    }
}