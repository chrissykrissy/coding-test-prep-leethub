class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] sb = new StringBuilder[Math.min(s.length(), numRows)];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        int row = 0;
        boolean goDown = false;
        for (char c : s.toCharArray()) {
            sb[row].append(c);
            if (row == 0 || row == numRows - 1) {
                goDown = !goDown;
            }
            row += goDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder strb : sb) {
            result.append(strb);
        }
        return result.toString();
    }
}