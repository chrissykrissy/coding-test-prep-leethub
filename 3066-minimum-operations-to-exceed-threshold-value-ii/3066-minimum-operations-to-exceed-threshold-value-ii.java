class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            if (n < k) pq.add(n);
        }

        int operations = 0;

        while (!pq.isEmpty()) {
            int x = pq.poll();
            operations++;
            if (pq.isEmpty()) break;

            int y = pq.poll();
            long newV = 2L * x + y;

            if (newV < k) pq.add((int) newV);
        }
        return operations;
    }
}