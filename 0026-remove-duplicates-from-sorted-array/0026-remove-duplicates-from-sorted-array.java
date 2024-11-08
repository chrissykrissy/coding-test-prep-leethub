class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = nums[0];
        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != prev) {
                prev = nums[i];
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}