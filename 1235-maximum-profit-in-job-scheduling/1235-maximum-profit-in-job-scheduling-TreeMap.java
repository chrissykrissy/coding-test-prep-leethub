class Solution {
    /*
          [    10  ]              --> 10 + 50 = 60 
    [   50   ]           [  50 ]  --> 50 + 50 = 100 = max profit 
    0, 1, 2, 3, 4, 5, 6, 7, 8, 9

    heap containing tuples of: [endTime, maxProfit ending at that time]
    t = 0, add [3, 50]
    t = 2, check heap. it's not empty but this current profit overlaps. add [5, 10] 
    t = 7, check heap. max profit we can make is max(50, 10) = 50 
    */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[profit.length][3];
        for (int i = 0; i < profit.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // Priority Queue sorted based on end time 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int currentMaxSoFar = 0; 
        int result = 0; 

        for (int[] job: jobs) {
            int start = job[0];
            int end = job[1];
            int jobProfit = job[2];

            // 1. Calculate maximum profit of all jobs that would have ended by this time 
            while (!pq.isEmpty() && pq.peek()[0] <= start) {
                currentMaxSoFar = Math.max(currentMaxSoFar, pq.poll()[1]); // pq.poll()[1] = the profit of the job 
            }

            // 2. Now that we have our max profit we can possibly obtain, add it back to the queue 
            pq.add(new int[]{end, jobProfit + currentMaxSoFar});
            result = Math.max(result, jobProfit + currentMaxSoFar);
        }

        return result;
    }
}