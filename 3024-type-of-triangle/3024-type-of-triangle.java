class Solution {
    public String triangleType(int[] nums) {
        if (!(nums[0] + nums[1] > nums[2] && nums[1] + nums[2] > nums[0] && nums[0] + nums[2] > nums[1])) {
            return "none";
        }
        long unique = Arrays.stream(nums).distinct().count();
        if (unique == 1) return "equilateral";
        else if (unique == 2) return "isosceles";
        else return "scalene";

    }
}