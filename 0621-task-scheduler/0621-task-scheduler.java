class Solution {
    class Process {
        char id;
        int lastTime;

        public Process(char id, int lastTime) {
            this.id = id;
            this.lastTime = lastTime;
        }

        public void setLastTime(int lastTime) {
            this.lastTime = lastTime;
        }

        public int getLastTime() {
            return this.lastTime;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < tasks.length; i++){
            freq.put(tasks[i], freq.getOrDefault(tasks[i], 0)+1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)-> freq.get(b) - freq.get(a));
        pq.addAll(freq.keySet());
        
        int time = 0;
        Queue<Process> cooldownQueue = new LinkedList<>();
        while (!pq.isEmpty() || !cooldownQueue.isEmpty()) {
            time++;

            // Check if there's any task available from cooldown queue to be re-added to pq
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek().getLastTime() <= time) {
                pq.add(cooldownQueue.poll().id);
            }

            // If pq is empty, we are in an idle state
            if (pq.isEmpty()) {
                continue;
            }

            // Process the next available task with the highest frequency
            char task = pq.poll();
            freq.put(task, freq.get(task) - 1);

            // If the task still has remaining frequency, put it into cooldown
            if (freq.get(task) > 0) {
                cooldownQueue.add(new Process(task, time + n + 1));
            }
        }
        return time;
    }
}