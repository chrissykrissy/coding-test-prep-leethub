class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
        );
        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.add(new int[]{i, 0});
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] popped = pq.poll();
            ret.add(Arrays.asList(nums1[popped[0]], nums2[popped[1]]));
            k--;

            if (popped[1] + 1 < nums2.length) {
                pq.add(new int[]{popped[0], popped[1] + 1});
            }
        }

        return ret;
    }
}