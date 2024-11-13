class Solution {
    /*
    - a good    example 
    - reversed: elpmaxe    goog a
    */
    public String reverseWords(String s) {
        s = s.trim();
        List<String> str = Arrays.asList(s.split("\\s+"));
        Collections.reverse(str);
        return String.join(" ", str);
    }
}