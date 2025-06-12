class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int dist = Math.abs(nums[nums.length-1]-nums[0]);
        for (int i = 0; i < nums.length-1; i++) {
            dist = Math.max(dist, Math.abs(nums[i]-nums[i+1]));
        }
        return dist;
    }
}