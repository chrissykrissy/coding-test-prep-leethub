class Solution {
    public int countTriples(int n) {
        int count = 0; 
        for (int i = 1; i < n; i++){
            for (int j = 1; j < n; j++) {
                if (isValidPair(i, j, n)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isValidPair(int i, int j, int n) {
        double sq = Math.sqrt(i * i + j * j);
        if (sq <= n) {
            if (Math.floor(sq) == sq) {
                return true;
            }
        }
        return false;
    }
}