class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ret = new int[(grid.length*grid.length)+1];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                ret[grid[i][j]]++;
            }
        }
        int[] sol = new int[2];
        for (int i = 0; i < ret.length; i++) {
            if (ret[i] == 2) {
                sol[0] = i;
            }
            if (ret[i] == 0) {
                sol[1] = i;
            }
        }
        return sol;
    }
}