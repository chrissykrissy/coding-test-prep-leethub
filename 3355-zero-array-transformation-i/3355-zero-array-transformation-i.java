class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diff = new int[nums.length];

        for (int[] i : queries) {
            diff[i[0]]++;
            if (i[1] + 1 < nums.length) {
                diff[i[1]+ 1]--;
            }
        }

        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt += diff[i];
            if (nums[i] > cnt) {
                return false;
            }
        }

        return true;

    }
}