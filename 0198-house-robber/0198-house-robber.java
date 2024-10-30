class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] rob = new int[nums.length+1];
        rob[0] = 0;
        rob[1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            rob[i+1] = Math.max(nums[i] + rob[i-1], rob[i]);
        }
        return rob[nums.length];
    }
}