class Solution {
    public int numOfSubarrays(int[] arr) {
        int count = 0, prefix = 0;
        int odd = 0, even = 1;

        for (int n : arr) {
            prefix += n;
            if (prefix % 2 == 0) {
                count += odd;
                even++;
            } else {
                count += even;
                odd++;
            }
            count %= 1_000_000_007;
        }
        return count;
    }
}