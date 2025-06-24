class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> set = new HashSet<>();
        List<Integer> keyset = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                keyset.add(i);
            }
        }

        for (Integer i : keyset) {
            int start = i - k;
            int end = i + k;
            if (start < 0) {
                start = 0;
            }
            if (end > nums.length - 1){
                end = nums.length-1;
            }
            for (int j = start; j <= end; j++) {
                set.add(j);
            }
        }
        return set.stream().sorted().collect(Collectors.toList());
    }
}