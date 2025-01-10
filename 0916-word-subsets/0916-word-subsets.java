class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        int[] tempFreq = new int[26];
        for (String word : words2) {
            Arrays.fill(tempFreq, 0);
            for (char c : word.toCharArray()) {
                tempFreq[c-'a']++;
            }
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], tempFreq[i]);
            }
        }
        List<String> universal = new ArrayList<>();

        for (String w : words1) {
            Arrays.fill(tempFreq, 0);
            for (char ch : w.toCharArray()) {
                tempFreq[ch-'a']++;
            }

            boolean isUni = true;
            for (int i = 0; i < 26; i++) {
                if (maxFreq[i] > tempFreq[i]) {
                    isUni = false;
                    break;
                }
            }
            if (isUni) {
                universal.add(w);
            }
        }
        return universal;
    }
}