class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.equals("")) {
            return true; 
        }
        // i pointer maps to t 
        // j pointer maps to s

        int i = 0, j = 0; 
        while (i < t.length() && j < s.length()) {
            // characters are same, move both forward 
            if (t.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            }
            // move i forward to try and find something that matches j 
            else {
                i++;
            }

            if (j == s.length()) {
                return true; 
            }
        }
        
        return false; 
    }
}