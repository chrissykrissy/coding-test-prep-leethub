class Solution {
    public int minOperations(int[] nums) {
        int total = 0;
        //int left = 0;
        for (int right = 0; right <= nums.length-3; right++) {
            if (nums[right] == 0) {
                int i = 0;
                while (i < 3) {
                    if (nums[right+i] == 0) {
                        nums[right+i] = 1;
                    } else {
                        nums[right+i] = 0;
                    }
                    i++;
                }
                total++;
            }
        }

        for (int i = nums.length-3; i < nums.length; i++) {
            if (nums[i] == 0) return -1;
        }

        return total;
    }
}