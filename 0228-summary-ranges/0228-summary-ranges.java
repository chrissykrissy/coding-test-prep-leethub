class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        if (nums.length == 0) return ret;
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end++;
            }else {
                ret.add(buildString(start, end));
                start = nums[i];
                end = nums[i];
            }
        }
        ret.add(buildString(start, end));
        return ret;
    }

    public String buildString(int i, int j) {
        if (i != j) {
            return i+"->"+j;
        }
        return String.valueOf(i);
    }
}