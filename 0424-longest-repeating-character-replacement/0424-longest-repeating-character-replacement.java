class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int result = 0;
        int left = 0;
        int[] freq = new int[26];
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            max = Math.max(freq[s.charAt(right) - 'A'], max);

            int range = right - left + 1;

            if (range - max > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            result = Math.max(result, right-left+1);
        }

        return result;
    }
}