class Solution {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) return true;
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (n % 2 == nums[i] % 2) {
                return false;
            }
            n = nums[i];
        }
        return true;
    }
}