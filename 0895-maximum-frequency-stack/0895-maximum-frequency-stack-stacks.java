class FreqStack {
    List<Stack<Integer>> bucket;
    HashMap<Integer, Integer> map;

    public FreqStack() {
        bucket = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0)+1);
        int freq = map.get(val);
        if(freq > bucket.size()){
            bucket.add(new Stack<Integer>());
        }
        bucket.get(freq-1).push(val);
    }
    
    public int pop() {
        int freq = bucket.size();
        int x = bucket.get(freq-1).pop();
        if(bucket.get(freq-1).isEmpty()){
            bucket.remove(bucket.size()-1);
        }
        map.put(x, map.get(x)-1);
        if(freq == 1) map.remove(x);
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */