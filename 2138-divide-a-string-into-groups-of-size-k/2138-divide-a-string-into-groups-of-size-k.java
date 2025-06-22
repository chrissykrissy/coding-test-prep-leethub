class Solution {
    public String[] divideString(String s, int k, char fill) {
        // Calculate the number of groups needed.
        // If s.length() is a multiple of k, total is s.length()/k.
        // Otherwise, it's s.length()/k + 1 for the partial last group.
        int totalGroups = (s.length() + k - 1) / k; // A common way to calculate ceil(s.length() / k)

        String[] result = new String[totalGroups];
        StringBuilder currentGroup = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            currentGroup.append(s.charAt(i));

            // If the current group reaches k characters, or we're at the end of the string
            // and this is the last group, then store it.
            if (currentGroup.length() == k || i == s.length() - 1) {
                // If it's the last group and it's not full, fill it.
                while (currentGroup.length() < k) {
                    currentGroup.append(fill);
                }
                // Determine the index for the current group
                int groupIndex = i / k; // This effectively calculates which group index we're filling
                result[groupIndex] = currentGroup.toString();
                currentGroup = new StringBuilder(); // Reset for the next group
            }
        }

        return result;
    }
}