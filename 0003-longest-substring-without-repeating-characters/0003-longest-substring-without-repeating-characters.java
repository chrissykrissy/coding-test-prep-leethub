class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int[] arr = new int[128];
        int i = 0;
        int j = 0;
        while (i <= j && j < s.length()) {
            if (arr[s.charAt(j)] < 1) {
                arr[s.charAt(j)]++;
                j++;
            } else {
                while (arr[s.charAt(i)] == 1) {
                    arr[s.charAt(i)]--;
                    i++;
                }
            }
            max = Math.max(max, j - i);
        }
        return max;
    }
}