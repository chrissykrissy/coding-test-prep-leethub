import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        // Step 1: Create a frequency map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;

        // Step 2: Iterate through the map and check for harmonious pairs
        for (int num : freqMap.keySet()) {
            // Check if num + 1 exists in the map
            if (freqMap.containsKey(num + 1)) {
                // If it does, calculate the length of the subsequence
                // formed by num and num + 1, and update maxLength
                maxLength = Math.max(maxLength, freqMap.get(num) + freqMap.get(num + 1));
            }
        }

        return maxLength;
    }
}