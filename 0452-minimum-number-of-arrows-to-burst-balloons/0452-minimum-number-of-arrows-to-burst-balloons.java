class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int prev = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i];
            if (curr[0] <= prev) {
                count++;
            } else {
                prev = curr[1];
            }
        }
        return points.length - count;
    }
}