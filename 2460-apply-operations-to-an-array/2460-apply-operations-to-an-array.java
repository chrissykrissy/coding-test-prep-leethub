class Solution {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int swap = i;
                while (swap < nums.length) {
                    if (nums[swap] != 0) {
                        nums[i] = nums[swap];
                        nums[swap] = 0;
                        break;
                    }
                    swap++;
                }
            }
        }
        return nums;
    }
}