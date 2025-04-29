class Solution {
    public long countSubarrays(int[] nums, int k) {
        long count = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int start = 0;
        int currMax = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == max) {
                currMax++;
            }
            while (currMax == k) {
                if (nums[start] == max) {
                    currMax--;
                }
                start++;
            }
            count += start;
        }
        return count;
    }
}