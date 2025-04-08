class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int[] freq = new int[101];

        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }

        int count = 0;
        for (int i = 0; i < n; i+=3) {
            if (!hasDuplicate(freq)) {
                return count;
            }
            for (int j = i; j < i+3 && j < n; j++) {
                freq[nums[j]]--;
            }
            count++;
        }
        return count;
    }

    public boolean hasDuplicate(int[] freq) {
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 1) {
                return true;
            }
        }
        return false;
    }
}