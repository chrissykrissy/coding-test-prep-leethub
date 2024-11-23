class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String, String> p2s = new HashMap<>();
        Map<String, String> s2p = new HashMap<>();
        String[] sarr = s.split(" ");
        if (sarr.length != pattern.length()) return false;
        for (int i = 0; i < sarr.length; i++) {
            String c = String.valueOf(pattern.charAt(i));
            if (!p2s.containsKey(c) && !s2p.containsKey(sarr[i])) {
                p2s.put(c, sarr[i]);
                s2p.put(sarr[i], c);
            }else {
                if (p2s.containsKey(c) && !p2s.get(c).equals(sarr[i])) {
                    return false;
                }

                if (s2p.containsKey(sarr[i]) && !s2p.get(sarr[i]).equals(c)) {
                    return false;
                }
            }
        }
        return true;
    }
}