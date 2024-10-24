class Solution {
    public int evalRPN(String[] tokens) {
        int total;
        Stack<Integer> num = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                int n1 = num.pop();
                int n2 = num.pop();
                num.push(n1+n2);
            }else if (s.equals("-")){
                int n1 = num.pop();
                int n2 = num.pop();
                num.push(n2-n1);
            }else if (s.equals("*")){
                int n1 = num.pop();
                int n2 = num.pop();
                num.push(n1 * n2);
            }else if (s.equals("/")){
                int n1 = num.pop();
                int n2 = num.pop();
                num.push(n2/n1);
            }else{
                Integer i = Integer.parseInt(s);
                num.push(i);
            }
        }
        return num.peek();
    }
}