class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[] rowFreq = new int[mat.length];
        int[] colFreq = new int[mat[0].length];

        Map<Integer,String> loc = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                loc.put(mat[i][j], new String(i+"#"+j));
            }
        }

        for (int i = 0; i < arr.length; i++) {
            String coord = loc.get(arr[i]);
            String[] rc = coord.split("#");
            rowFreq[Integer.parseInt(rc[0])]++;
            if (rowFreq[Integer.parseInt(rc[0])] == mat[0].length) {
                return i;
            }
            colFreq[Integer.parseInt(rc[1])]++;
            if (colFreq[Integer.parseInt(rc[1])] == mat.length) {
                return i;
            }
        }
        return -1;
    }
}