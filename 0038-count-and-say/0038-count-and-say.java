class Solution {
    /*
    1 = "1" 
    2 = "1" (one 1 ^) 
    3 = "21" (two 1s ^)
    4 = "1211" (one 2 + one 1 ^) 

    - set s to be initially "1"
    - initialize a loop from 1 to n - 1 
        - pass s into a function and set it back, so s = helper(s) 
    
    - every time the helper function runs:  
        - keep track of first character in string as C and initialize count = 1 
        - loop from 1 to end of string, keep track of current character 
            if current character is same as C, increment count 
            else 
                append count to string, then append character to string 
                set C to current character, reset count to 1 
        - at the end of the loop we will still have C and count, append those to string 
    */
    public String countAndSay(int n) {
        String s = "1"; 
        for (int i = 1; i < n; i++) {
            s = countHelper(s);
        }
        return s; 
    }

    public String countHelper(String s) {
        StringBuilder sb = new StringBuilder(); 
        char c = s.charAt(0); 
        int count = 1; 

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i); 
            if (s.charAt(i) == c) {
                count++;
            }
            else {
                // we have reached a different number, compute 
                sb.append(count).append(c);
                c = s.charAt(i);
                count = 1;
            }
        }

        sb.append(count).append(c);
        return sb.toString();
    }
}