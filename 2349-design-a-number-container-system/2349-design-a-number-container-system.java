class NumberContainers {
    Map<Integer, TreeSet<Integer>> num2con;
    Map<Integer, Integer> con2num;

    public NumberContainers() {
        num2con = new HashMap<>();
        con2num = new HashMap<>();
    }
    
    public void change(int index, int number) {
        //check if the container is already filled with something else
        if (con2num.containsKey(index)) {
            int prev = con2num.get(index);
            num2con.get(prev).remove(index);
            if (num2con.get(prev).isEmpty()) {
                num2con.remove(prev);
            }
        }

        if (!num2con.containsKey(number)) {
            num2con.put(number, new TreeSet<>());
        }

        num2con.get(number).add(index);
        con2num.put(index, number);
        
    }
    
    public int find(int number) {
        if (!num2con.containsKey(number)) {
            return -1;
        }
        return num2con.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */