class Solution {
    
    public int calculate(String s){
        Stack<Integer> stk = new Stack<>();
        int answer = 0, sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int sum = c - '0';
                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    sum = sum * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                answer += sum * sign;
            }else if(c == '+'){
                sign = 1;
            }else if(c == '-'){
                sign = -1;
            }else if(c == '('){
                stk.push(answer);
                stk.push(sign);
                answer = 0;
                sign = 1;
            }else if(c == ')'){
                answer = answer * stk.pop() + stk.pop();
            }
        }
        
        return answer;
    }
}