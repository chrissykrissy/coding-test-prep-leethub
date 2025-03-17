class Solution {
    public boolean divideArray(int[] nums) {
        if (nums.length % 2 != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) == 2) {
                    map.remove(nums[i]);
                }
            } else {
                map.put(nums[i], 1);
            }
        }

        if (map.size() > 0) {
            return false;
        }

        return true;
    }
}