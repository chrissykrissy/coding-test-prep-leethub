class Solution {
    public int possibleStringCount(String word) {
        Map<Character, Integer> map = new HashMap<>();
        int ret = 1;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) == i-1) {
                    ret++;
                    map.put(c, i);
                }
            }
            map.put(c, i);
        }
        return ret;
    }
}