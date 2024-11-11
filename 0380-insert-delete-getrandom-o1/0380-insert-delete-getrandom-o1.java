class RandomizedSet {
    List<Integer> set;
    Map<Integer, Integer> map;
    Random rand;
    public RandomizedSet() {
        this.set = new ArrayList<>();
        this.map = new HashMap<>();
        this.rand = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            set.add(val);
            map.put(val, set.size()-1);
            // System.out.println(set);
        }
        return true;
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int temp = set.get(set.size()-1);
            set.set(map.get(val), temp);
            set.remove(set.size()-1);
            map.put(temp, map.get(val));
            map.remove(val);
            //System.out.println(set);
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        return set.get(rand.nextInt(set.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */