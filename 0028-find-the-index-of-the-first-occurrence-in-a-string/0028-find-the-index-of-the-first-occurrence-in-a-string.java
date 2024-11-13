class Solution {
    int[] table;
    public int strStr(String haystack, String needle) {
        makeTable(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = table[j - 1];
            }

            if (needle.charAt(j) == haystack.charAt(i)) {
                j += 1;
            }

            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        
        return -1;
    }
    public void makeTable(String pattern) {
        int pLen = pattern.length();
        table = new int[pLen];
        int index = 0;
        for (int i = 1; i < pLen; i++) {
            while (index > 0 && pattern.charAt(i) != pattern.charAt(index)) {
                index = table[index - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(index)) {
                index += 1;
                table[i] = index;
            } else {
                table[i] = 0;
            }
            
        }
    }
    
}