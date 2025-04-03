class Solution {
    public long maximumTripletValue(int[] nums) {
        long imax = 0, dmax = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(dmax*nums[i], res);
            dmax = Math.max(imax - nums[i], dmax);
            imax = Math.max(imax, nums[i]);
        }
        return res < 0 ? 0 : res;
    }
}