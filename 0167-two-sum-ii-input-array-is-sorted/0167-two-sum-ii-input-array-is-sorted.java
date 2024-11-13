class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                ret[0] = left+1;
                ret[1] = right+1;
                break;
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return ret;
    }
}