class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[profit.length][3];
        for(int i = 0; i < profit.length; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        
        int maxSoFar = 0;
        int res = 0;

        for(int[] j : jobs){
            int start = j[0];
            int end = j[1];
            int p = j[2];

            //calc max profit of all jobs that would have ended by this time
            while(!pq.isEmpty() && pq.peek()[0] <= start){
                maxSoFar = Math.max(maxSoFar, pq.poll()[1]);
            }

            //now that we have our max profit we can obtain, add it back to the q
            pq.add(new int[]{end, p + maxSoFar});
            res = Math.max(res, p + maxSoFar);
        }
        return res;
    }
}