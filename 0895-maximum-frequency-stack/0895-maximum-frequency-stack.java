class FreqStack {
    HashMap<Integer, Integer> freq;
    PriorityQueue<Element> pq;
    int time;
    class Element{
        int val;
        int freq;
        int time;
        public Element(int val, int freq, int time){
            this.val = val;
            this.freq = freq;
            this.time = time;
        }
    }

    public FreqStack() {
        this.freq = new HashMap<>();
        this.pq = new PriorityQueue<>((a,b) -> {
            int ord = b.freq - a.freq;
            if(ord == 0){
                return b.time - a.time;
            }
            return ord;
        });
        this.time = 0;
    }
    
    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0)+1);
        pq.offer(new Element(val, freq.get(val), time));
        time++;
    }
    
    public int pop() {
        Element pop = pq.poll();
        freq.put(pop.val, freq.get(pop.val)-1);
        return pop.val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */