class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        //increasing
        int max = 1;
        int temp = nums[0];
        for (int left = 0; left < nums.length; left++) {
            temp = nums[left];
            for (int right = left + 1; right < nums.length; right++) {
                if (nums[right] > temp) {
                    max = Math.max(max, right - left + 1);
                    temp = nums[right];
                } else {
                    break;
                }
            }
        }

        int temp2 = nums[0];
        for (int left = 0; left < nums.length; left++) {
            temp2 = nums[left];
            for (int right = left + 1; right < nums.length; right++) {
                if (nums[right] < temp2) {
                    max = Math.max(max, right - left + 1);
                    temp2 = nums[right];
                }else {
                    break;
                }
            }
        }

        return max;
        
    }
}