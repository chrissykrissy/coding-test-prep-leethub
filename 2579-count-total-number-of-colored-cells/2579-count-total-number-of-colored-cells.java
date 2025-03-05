class Solution {
    public long coloredCells(int n) {
        int[] map = new int[100000];
        if (n == 1) return 1;
        if (n == 2) return 5;
        else {
            return (long) Math.pow(n, 2) + (long) Math.pow(n-1, 2);
        }
    }
}