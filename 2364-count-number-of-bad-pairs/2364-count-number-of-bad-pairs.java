class Solution {
    public long countBadPairs(int[] nums) {

        // 4-0 = 4
        // 1-1 = 0
        // 3-2 = 1
        // 3-3 = 0
        // map : 4 - 1, 0 - 2, 1 - 1
        long n = nums.length;
        long count = (n*(n-1))/2;
        Map<Integer, Long> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i]-i, map.getOrDefault(nums[i]-i, 0L) + 1);
        }

        long sum = 0;
        for (Map.Entry<Integer,Long> e : map.entrySet()) {
            if (e.getValue() > 1) {
                sum += (e.getValue() * (e.getValue()-1))/2;
            }
        }

        return count-sum;

    }
}