class Solution {
    public int myAtoi(String s) {
        int sign = 1, base = 0, i = 0;
        while(i < s.length() && s.charAt(i) == ' ') i++;
        if(i >= s.length()) return 0;
        if(s.charAt(i) == '+' || s.charAt(i) == '-'){
            if(s.charAt(i) == '-') sign = -1;
            i++;
        }
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            if(base > Integer.MAX_VALUE/10 || (base == Integer.MAX_VALUE/10 && s.charAt(i) - '0' > 7)){
                if(sign == -1) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            base = 10 * base + (s.charAt(i)-'0');
            i++;
        }
        return base * sign;
    }
}