class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stk = new Stack<>();

        int i = 1;
        while (i <= pattern.length()) {
            stk.push(i);
            if (pattern.charAt(i-1) == 'I') {
                while(!stk.isEmpty()) {
                    sb.append(stk.pop());
                }
            }
            i++;
        }
        stk.push(i);
        while(!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.toString();
    }
}