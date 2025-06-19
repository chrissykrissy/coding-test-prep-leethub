class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int p = 0;

        int left = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] - nums[left] > k) {
                p++;
                left = i;
            }
        }

        return p+1;
    }
}