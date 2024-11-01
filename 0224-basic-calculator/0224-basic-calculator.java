class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int result = 0;
        int sign = 1; //-1 for neg
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c-'0');
            }else if(c == '+'){
                result += sign * num;
                sign = 1;
                num = 0;
            }else if (c == '-'){
                result += sign * num;
                sign = -1;
                num = 0;
            }else if (c == '('){
                stk.push(result);
                stk.push(sign);
                
                //rest new eval coming for sub
                sign = 1;
                result = 0;
            }else if (c == ')'){
                result += sign * num;
                result *= stk.pop();
                result += stk.pop();
                num = 0;
            }
        }
        return result + (sign * num);
    }
}