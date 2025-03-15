class Solution {
    public int minCapability(int[] nums, int k) {
        int minReward = 1;
        int maxReward = Arrays.stream(nums).max().getAsInt();
        int total = nums.length;

        while (minReward < maxReward) {
            int mid = (minReward + maxReward) / 2;
            int possible = 0;

            for (int i = 0; i < total; i++) {
                if (nums[i] <= mid) {
                    possible += 1;
                    i++;
                } 
            }

            if (possible >= k) maxReward = mid;
            else minReward = mid + 1;
        }
        return minReward;
    }
}