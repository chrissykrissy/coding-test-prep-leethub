class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sTot = new int[128];
        int[] tTos = new int[128];
        for (int i = 0; i < s.length(); i++) {
            if (sTot[s.charAt(i)] != tTos[t.charAt(i)]) {
                return false;
            }
            sTot[s.charAt(i)] = i+1;
            tTos[t.charAt(i)] = i+1;
        }
        return true;
    }
}