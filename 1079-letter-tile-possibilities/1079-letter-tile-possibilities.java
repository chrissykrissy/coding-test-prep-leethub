class Solution {
    public int numTilePossibilities(String tiles) {
        if (tiles.length() == 1) return 1;

        Set<String> set = new HashSet<>();
        boolean[] used = new boolean[tiles.length()];
        combination(set, tiles, "", used);
        return set.size() - 1;
    }

    public void combination(Set<String> set, String tiles, String curr, boolean[] used) {
        set.add(curr);

        for (int i = 0; i < tiles.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                combination(set, tiles, curr + tiles.charAt(i), used);
                used[i] = false;
            }
        }
    }


}