class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c)+1);
        }
        int odd = 0;
        int even = Integer.MAX_VALUE;
        for (int v : map.values()){
            if (v % 2 == 0) {
                even = Math.min(v, even);
            } else {
                odd = Math.max(v, odd);
            }
        }
        return odd-even;
    }
}