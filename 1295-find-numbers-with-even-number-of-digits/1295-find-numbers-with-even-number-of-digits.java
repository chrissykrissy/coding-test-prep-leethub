class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        int curr = 0;
        for (int i : nums) {
            while (i != 0) {
                curr++;
                i /= 10;
            }
            if (curr % 2 == 0) {
                count++;
            }
            curr = 0;
        }
        return count;
    }
}