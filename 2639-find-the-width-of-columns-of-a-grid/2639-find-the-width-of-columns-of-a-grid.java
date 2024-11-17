class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int[] array = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                array[j] = Math.max(array[j], String.valueOf(grid[i][j]).length());
            }
        }
        return array;
    }
}