class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int substringLength = wordLength * words.length;
        if (s.length() < substringLength) {
            return result;
        }

        // Count the frequency of each word in the array
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Slide over the string `s` in windows of `substringLength`
        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i;
            int count = 0;
            Map<String, Integer> windowCount = new HashMap<>();

            while (right + wordLength <= s.length()) {
                // Add a word from the right side of the window
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                if (wordCount.containsKey(word)) {
                    windowCount.put(word, windowCount.getOrDefault(word, 0) + 1);
                    count++;

                    // Shrink the window until it becomes valid
                    while (windowCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        windowCount.put(leftWord, windowCount.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }

                    // Check if we have a valid substring
                    if (count == words.length) {
                        result.add(left);
                    }
                } else {
                    // Reset the window if the word is not in `words`
                    windowCount.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return result;
    }
}