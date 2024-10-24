class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] c : prerequisites){
            adj.get(c[1]).add(c[0]);
            indegree[c[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int visited = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            visited++;
            for(int n : adj.get(node)){
                indegree[n]--;
                if(indegree[n] == 0){
                    q.offer(n);
                }
            }
        }
        return visited == numCourses;

    }
}