class Solution {
    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        combination(list, sb, n);
        if (list.size() < k) return "";
        return list.get(k-1);
    }

    private void combination(List<String> list, StringBuilder sb, int n) {
        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (sb.length() >= 1) {
                if (sb.charAt(sb.length()-1) != (char)('a' + i)) {
                    sb.append((char)('a' + i));
                } else {
                    continue;
                }
            } else{
                sb.append((char)('a' + i));
            }
            combination(list, sb, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}