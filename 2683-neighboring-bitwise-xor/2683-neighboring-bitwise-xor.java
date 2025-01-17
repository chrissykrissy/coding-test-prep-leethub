class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int sum = 0;
        for (int i : derived) {
            sum ^= i;
        }

        if (sum == 0) return true;
        return false;
    }
}