class Solution {
    /*
    - a good    example 
    - reversed: elpmaxe    goog a
    */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.split(" ");
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].length() == 0) continue;
            sb.append(str[i].trim());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}