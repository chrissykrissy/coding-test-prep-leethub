class MinStack {
    class Node{
        int min;
        int val;
        public Node(int min, int val){
            this.min = min;
            this.val = val;
        }
    }
    
    int currMin;
    Stack<Node> stk;

    public MinStack() {
        this.stk = new Stack<>();
        this.currMin = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        currMin = Math.min(val, currMin);
        stk.push(new Node(currMin, val));
    }
    
    public void pop() {
        stk.pop();
        if(stk.isEmpty()){
            currMin = Integer.MAX_VALUE;
        }else{
            currMin = stk.peek().min;
        }
    }
    
    public int top() {
        return stk.peek().val;
    }
    
    public int getMin() {
        return stk.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */