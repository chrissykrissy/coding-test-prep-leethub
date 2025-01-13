class Solution {
    public int minimumLength(String s) {
        int[] alph = new int[26];
        for (char c : s.toCharArray()) {
            alph[c-'a']++;
        }
        int total = 0;

        for (int i = 0; i < 26; i++) {
            if (alph[i] < 3) {
                total += alph[i];
            } else if (alph[i] >= 3) {
                if (alph[i] % 2 == 1) {
                    total += 1;
                }else {
                    total += 2;
                }
            }
        }
        return total; 
    }
}